package evanq.game.net;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
public class NetServiceAdaptor implements Runnable {

	/**
	 * 以下罗列出此对象的服务状态
	 */
	private static final byte NET_SERVICE_STATE_IDLE = 1;
	private static final byte NET_SERVICE_STATE_OPENING = 2;
	private static final byte NET_SERVICE_STATE_OPENED = 3;
	private static final byte NET_SERVICE_STATE_CLOSEED = 4;

	private NetServiceType type;

	private String host;

	private int port;

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
	private List<INetCloseListener> closeListeners = new LinkedList<INetCloseListener>();
	
	//start listener
	private List<INetStartListener> startListeners = new LinkedList<INetStartListener>();
	
	
	/**
	 * 
	 * @see INetConnectionManager
	 */
	private INetConnectionManager netManager;
	
	/**
	 * 
	 * 服务初始化工具，能够根据连接的类型，分配不同的编码、解码器
	 * 
	 * @see DefaultNettyInitializer
	 */
	private DefaultNettyInitializer nettyInitializer;
	
	public NetServiceAdaptor(NetServiceType type, int port,INetConnectionManager netManager) {
		this(type,null,port,netManager,null);
	}

	public NetServiceAdaptor(NetServiceType type, String host, int port,INetConnectionManager netManager) {

		this(type, host, port,netManager,null);
	}

	/**
	 * 
	 * @param type
	 * @param host
	 * @param port
	 * @param netManager
	 * @param nettyInitializer
	 */
	public NetServiceAdaptor(NetServiceType type, String host, int port,INetConnectionManager netManager,DefaultNettyInitializer nettyInitializer) {
		
		if (port < 1024 || port > 63365) {
			throw new IllegalArgumentException("端口控制在1024-63365之间");
		}
		
		if (null == host) {
			if (type == NetServiceType.SERVER) {
				host = "0.0.0.0";
			} else {
				throw new NullPointerException("host");
			}
		}
		
		
		if (null == netManager) {
			netManager = newINetManager();
		}
		this.netManager = netManager;
		
		if (null == nettyInitializer) {
			nettyInitializer = newNettyInitializer();
		}
		
		this.nettyInitializer = nettyInitializer;		
		this.type = type;
		this.host = host;
		this.port = port;
		
		thread = new Thread(this,""+type +"-"+threadCounter.getAndIncrement());
		
	}
	
	protected INetConnectionManager newINetManager(){
		return AbstractNetConnectionManager.getInstance();
	}
	
	protected DefaultNettyInitializer newNettyInitializer(){
		return new DefaultNettyInitializer(this.netManager);
	}

	@Override
	public void run() {

		synchronized (stateLock) {
			state = NET_SERVICE_STATE_OPENED;
		}

		//TODO 绑定数据包
		PacketAllocator.getInstance().doRegister();

		switch (type) {
		case CLIENT:
			openClientConnect0();
			break;
		case SERVER:
			openServer0();
			break;
		}
		synchronized (stateLock) {
			state = NET_SERVICE_STATE_IDLE;
		}
	}

	public void open() {

		synchronized (stateLock) {

			if (state == NET_SERVICE_STATE_IDLE) {

				state = NET_SERVICE_STATE_OPENING;
				thread.start();
			}
		}
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
					
					for (INetStartListener l : startListeners) {
						l.onStart(NetServiceAdaptor.this.channel);
					}
				}
			});
			
			channel =  bindFuture.sync().channel();
			channel.closeFuture().addListener(new GenericFutureListener<Future<? super Void>>() {

				@Override
				public void operationComplete(
						Future<? super Void> future) throws Exception {
					for (INetCloseListener l : closeListeners) {
						l.onClose(NetServiceAdaptor.this.channel); 
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
					
					for (INetStartListener l : startListeners) {
						l.onStart(NetServiceAdaptor.this.channel);
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
						for (INetCloseListener l : closeListeners) {
							l.onClose(NetServiceAdaptor.this.channel); 
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
	
	public void addStartListener(INetStartListener startListener){
	
		if(NET_SERVICE_STATE_OPENED <= state){
			throw new IllegalAccessError("必须open() 之前注册startListener");
		}
		if (null == startListener) {
			throw new NullPointerException("startListener");
		}
		this.startListeners.add(startListener);
	}
	
	public void addCloseListener(INetCloseListener closeListener){
		
		if (null == closeListener) {
			throw new NullPointerException("closeListener");
		}
		
		this.closeListeners.add(closeListener);;
	}
	
}
