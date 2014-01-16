package evanq.game.net;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.Attribute;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;

//TODO 增加断线重连特性
//TODO 增加关闭通知所有客户端特性
//TODO 增加连接心跳特性
//TODO 增加连接状态管理

/**
 * 
 * 网络服务驱动
 * 
 * @author Evan cppmain@gmail.com
 * 
 */
public class NetServiceAdaptor implements INetService, Runnable {

	private Trace logger = LogSystem.getDefaultTrace(NetServiceAdaptor.class);
	
	
	/**
	 * 以下罗列出此对象的服务状态
	 */
	private static final byte NET_SERVICE_STATE_IDLE    = 1;
	private static final byte NET_SERVICE_STATE_OPENING = 2;
	private static final byte NET_SERVICE_STATE_OPENED  = 3;
	private static final byte NET_SERVICE_STATE_CLOSEED = 4;

	/**
	 * 网络IO 服务的类型（客户端，服务器，agent）
	 */
	protected NetServiceType type;

	/**
	 * 
	 * 连接的类型（用于连接管理器识别）
	 */
	protected NetConnectionType connectionType;
	
	protected String host;

	protected int port;

	/**
	 * the channel of net service
	 */
	protected Channel channel;

	private Thread thread;
	private static AtomicInteger threadCounter = new AtomicInteger(1);
	//private boolean runInThread=true;//false 的情况调试没有通过，没有阻塞直接运行shutdown代码

	private byte state = NET_SERVICE_STATE_IDLE;
	private Object stateLock = new Object();

	//close listener
	protected LinkedList<IChannelDisposeListener> closeListeners = new LinkedList<IChannelDisposeListener>();
	
	//start listener
	protected LinkedList<IChannelCreateListener> startListeners = new LinkedList<IChannelCreateListener>();
	
	/**
	 * 
	 * 服务初始化工具，能够根据连接的类型，分配不同的编码、解码器
	 * 
	 * @see DefaultNettyInitializer
	 */
	protected AbstractNettyChannelInitializer nettyInitializer;
	
	
	private INetServiceHandler netServiceHandler;
	
	/**
	 * @param serviceType
	 * @param port
	 * @param handler
	 */
	public NetServiceAdaptor(NetServiceType serviceType,int port, INetServiceHandler handler){
		this(serviceType,null,port,handler,null);
	}
	
	/**
	 * 
	 * @param serviceType
	 * @param host
	 * @param port
	 * @param handler
	 */
	public NetServiceAdaptor(NetServiceType serviceType,String host, int port, INetServiceHandler handler) {
		this(serviceType,host,port,handler,null);
	}
	/**
	 * 
	 * @param serviceType
	 * @param host
	 * @param port
	 * @param handler
	 */
	public NetServiceAdaptor(NetServiceType serviceType,String host, int port, INetServiceHandler handler,AbstractNettyChannelInitializer nettyInitializer){
		
		if (port < 1024 || port > 63365) {
			throw new IllegalArgumentException("端口控制在1024-63365之间");
		}
		
		if (null == host) {
			if (type != NetServiceType.CLIENT) {
				host = "0.0.0.0";
			} else {
				throw new NullPointerException("host");
			}
		}
		connectionType = NetConnectionType.DUMMY;

		if(null == handler){
			throw new NullPointerException("handler");
		}
		
		this.netServiceHandler = handler;

		if (null == nettyInitializer) {
			nettyInitializer = newNettyInitializer();
		}
		this.nettyInitializer = nettyInitializer;		
		this.type = serviceType;
		this.host = host;
		this.port = port;
		
		thread = new Thread(this,""+type +"-"+threadCounter.getAndIncrement());

	}
		
	protected AbstractNettyChannelInitializer newNettyInitializer(){
		return new DefaultNettyInitializer(this.netServiceHandler);
	}

	@Override
	public void run() {

		synchronized (stateLock) {
			state = NET_SERVICE_STATE_OPENED;
		}
		
		boolean controlRetry= false;
		
		do{
			switch (type) {
			case CLIENT:
				openClientConnect0();
				//TODO 控制客户端断线重连
				break;
			case SERVER:
			case AGENT_SERVER:
			case AGENT_CLIENT:
				openServer0();
				break;
			}
			
		} while (controlRetry);
		
		synchronized (stateLock) {
			state = NET_SERVICE_STATE_IDLE;
		}
	}

	public void open() {
		if(state ==NET_SERVICE_STATE_OPENING ){
			throw new IllegalMonitorStateException("重复开启");
		}
		if(type == NetServiceType.CLIENT){
			
			addChannelCreateListener0(new IChannelCreateListener() {
				
				@Override
				public void onCreate(Channel channel) {
					if(null == connectionType){
						logger.warn("connectionType is null when create connection");
					}
					Attribute<NetConnectionType> attr = channel.attr(NettyNetConnectionManagerAdaptor.NETCONNECTION_TYPE_ATTR);
					attr.set(connectionType);					
				}
			});
		}
		
		synchronized (stateLock) {

			if (state == NET_SERVICE_STATE_IDLE) {

				state = NET_SERVICE_STATE_OPENING;
				thread.start();
			}
		}
	}
	
	@Override
	public void open(NetConnectionType type) {
		connectionType(type);
	
		open();
	}
	
	public boolean isOpen(){
		return state == NET_SERVICE_STATE_OPENED;
	}
	
	private void openServer0() {

		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();

		try {

			ServerBootstrap boot = new ServerBootstrap();
			boot.group(bossGroup, workGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(nettyInitializer);
			ChannelFuture bindFuture = boot.bind(this.port	);
			
			bindFuture.addListener(new GenericFutureListener<Future<? super Void>>() {

				@Override
				public void operationComplete(Future<? super Void> future)
						throws Exception {
					logger.info("{} listen at {}:{}",type,host,port);
				
					for (IChannelCreateListener l : startListeners) {
						l.onCreate(NetServiceAdaptor.this.channel);
					}
				}
			});
			
			channel =  bindFuture.sync().channel();

			channel.closeFuture().addListener(new GenericFutureListener<Future<? super Void>>() {

				@Override
				public void operationComplete(
						Future<? super Void> future) throws Exception {
					
					logger.info("{} for {}:{} closing!",type,host,port);
					for (IChannelDisposeListener l : closeListeners) {
						
						l.onDispose(NetServiceAdaptor.this.channel); 
					}
				}
			}).sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
			
			startListeners.clear();
			closeListeners.clear();
		}
	}

	/**
	 * 
	 */
	private void openClientConnect0() {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).handler(nettyInitializer)
					.channel(NioSocketChannel.class);

			ChannelFuture connectFutrue = b.connect(host, port);
			connectFutrue.addListener(new GenericFutureListener<Future<? super Void>>() {

				@Override
				public void operationComplete(Future<? super Void> future)
						throws Exception {
					logger.info("{} connect to {}:{}",type,host,port);
					for (IChannelCreateListener l : startListeners) {
						l.onCreate(NetServiceAdaptor.this.channel);
					}
				}
			});
			
			try {

				channel = connectFutrue.sync().channel();
			
				//发生关闭，阻塞到关闭完成
				channel.closeFuture().addListener(new GenericFutureListener<Future<? super Void>>() {

					@Override
					public void operationComplete(
							Future<? super Void> future) throws Exception {						
						
						logger.info("{} to {}:{} closing!",type,host,port);
						for (IChannelDisposeListener l : closeListeners) {
							l.onDispose(NetServiceAdaptor.this.channel); 
						}
					}
				}).sync();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			group.shutdownGracefully();
			startListeners.clear();
			closeListeners.clear();
		}
		
	}

	public void close() {

		synchronized (stateLock) {

			if (null != channel ) {
				channel.close();				
			}

			state = NET_SERVICE_STATE_CLOSEED;
		}
	}
	
	/**
	 * 在对头增加
	 * 
	 * @param startListener
	 */
	private void addChannelCreateListener0(IChannelCreateListener startListener){
		this.startListeners.addFirst(startListener);
	}
	
	public void addChannelCreateListener(IChannelCreateListener startListener){
	
		if(NET_SERVICE_STATE_OPENED <= state){
			throw new IllegalAccessError("必须open() 之前注册startListener");
		}
		if (null == startListener) {
			throw new NullPointerException("startListener");
		}
		
		this.startListeners.add(startListener);
	}
	
	public void addChannelDisposeListener(IChannelDisposeListener closeListener){
		
		if (null == closeListener) {
			throw new NullPointerException("closeListener");
		}
		
		this.closeListeners.add(closeListener);;
	}

	@Override
	public NetServiceType serviceTye() {
		return type;
	}

	@Override
	public NetConnectionType connectionType() {
		return connectionType;
	}
	
	
	public NetConnectionType connectionType(NetConnectionType connectionType) {
		this.connectionType = connectionType;
		return this.connectionType;
	}
	
}
