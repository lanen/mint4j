package evanq.game.net;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;
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
		
		switch (type) {
		case CLIENT:
			openClientConnect0();		
			break;
		case SERVER:
		case AGENT_SERVER:
		case AGENT_CLIENT:
			openServer0();
			break;
		}
		
		synchronized (stateLock) {
			state = NET_SERVICE_STATE_IDLE;
		}
	}

	public void open() {
		if(state == NET_SERVICE_STATE_OPENING ){
			throw new IllegalMonitorStateException("重复开启");
		}
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
		try{		

			ServerBootstrap boot = new ServerBootstrap();
			boot.group(bossGroup, workGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(nettyInitializer);
			ChannelFuture bindFuture = boot.bind(this.port	);
			
			bindFuture.awaitUninterruptibly();
			
			if ( bindFuture.isCancelled() ) {
				// Connection attempt cancelled by user
			
			} else if (!bindFuture.isSuccess()) {
				logger.info("{} listen at {}:{} Failed",type,host,port);
				bindFuture.cause().printStackTrace();
				
			} else {
				channel = bindFuture.channel();
				
				logger.info("{} listen at {}:{}",type,host,port);
				
				for (IChannelCreateListener l : startListeners) {
					l.onCreate(NetServiceAdaptor.this.channel);
				}
				
				channel.closeFuture().awaitUninterruptibly();
				
				logger.info("{} for {}:{} closing!",type,host,port);
				
				for (IChannelDisposeListener l : closeListeners) {
					
					l.onDispose(NetServiceAdaptor.this.channel); 
				}
			}		
		
		} finally {
			
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
			
			startListeners.clear();
			closeListeners.clear();
		}
	}

	private  synchronized void openClientConnect0(){
		EventLoopGroup group = new NioEventLoopGroup();
		
		Bootstrap b = new Bootstrap();
		b.group(group).handler(nettyInitializer)
				.channel(NioSocketChannel.class);
		b.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);
		//TODO 控制客户端断线重连，配置信息
		boolean willRetry= false;
		int delayRetryTime = 5000;
		try{
			
			do{
				boolean donotRetry = openClientConnect0(b);
				if( ! donotRetry ) {				
					awaitForRetry(delayRetryTime);					
					willRetry = true;
					continue;
				}
				synchronized (stateLock) {
					state = NET_SERVICE_STATE_OPENED;	
				}
				
				//try 防止正常运行，服务器断开，这时候重连
				try {
					openClientConnect1();
				} catch (IOException e) {
					awaitForRetry(delayRetryTime);
					willRetry = true;
					continue;
				}
				
				willRetry = false;
				
			}while(willRetry);
			
			
		}finally{
			group.shutdownGracefully();
			startListeners.clear();
			closeListeners.clear();
		}
		
	}
	
	/**
	 * 绑定客户端连接关闭完成事件
	 */
	private void openClientConnect1() throws IOException {
		
		if(null == channel)return ;
	
		channel.closeFuture().awaitUninterruptibly();
		
		if(state == NET_SERVICE_STATE_CLOSEED){
			//属于正常断开
			logger.info("{} to {}:{} closing!",type,host,port);
		
			if(null == connectionType){
				logger.warn("connectionType is null when create connection");
			}

			for (IChannelDisposeListener l : closeListeners) {
				l.onDispose(NetServiceAdaptor.this.channel); 
			}
		}else{
			synchronized (stateLock) {
				state = NET_SERVICE_STATE_CLOSEED;	
			}
			throw new IOException("非正常断开");
		}
				
	}
	/**
	 * 开始连接，成功会时候channel !=null
	 * return true do not retry.
	 */
	private boolean openClientConnect0(Bootstrap b) {
			
		ChannelFuture connectFutrue = b.connect(host, port);
		
		//阻塞等待连接完成
		connectFutrue.awaitUninterruptibly();
		if ( connectFutrue.isCancelled() ) {
			// Connection attempt cancelled by user
			return true;
		} else if (!connectFutrue.isSuccess()) {
			logger.warn("{} connect to {}:{} Failed",type,host,port);				
			return false;
			//connectFutrue.cause().printStackTrace();
		} else {
			channel = connectFutrue.channel();
			
			//需要服务器验证之后，才会根据connectionType 设定编解码器
			AbstractNettyChannelInitializer.setChannelType(channel, connectionType);
			
			logger.info("{} connect to {}:{} Success",type,host,port);						
			
			for (IChannelCreateListener l : startListeners) {
				l.onCreate(NetServiceAdaptor.this.channel);
			}
			return true;
		}
		
		
	}
	
	private void awaitForRetry(int delayRetryTime){
		logger.info("{} delay {}ms,than Retry connect {}:{}",type,delayRetryTime,host,port);
	
		try {
			wait(delayRetryTime);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
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
