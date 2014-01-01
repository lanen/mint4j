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

import evanq.game.net.client.NettyClientInitializer;

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
	
	public NetServiceAdaptor(NetServiceType type, int port,INetConnectionManager netManager) {

		if (port < 1024 || port > 63365) {
			throw new IllegalArgumentException("端口控制在1024-63365之间");
		}

		if (null == netManager) {
			netManager = newINetManager();
		}
		this.netManager = netManager;
		
		this.type = type;
		this.port = port;

		thread = new Thread(this,""+type);
	}

	protected INetConnectionManager newINetManager(){
		return AbstractNetConnectionManager.getInstance();
	}
	
	public NetServiceAdaptor(NetServiceType type, String host, int port,INetConnectionManager netManager) {

		this(type, port,netManager);

		if (null == host) {
			if (type == NetServiceType.SERVER) {
				host = "0.0.0.0";
			} else {
				throw new NullPointerException("host");
			}
		}

		this.host = host;
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
					.childHandler(new NettyInitializer(netManager));
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

			channel.closeFuture().sync();
			
			

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}

	/**
	 * 
	 */
	private void openClientConnect0() {

		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).handler(new NettyInitializer(netManager))
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
				channel.closeFuture().sync();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			group.shutdownGracefully();
		}
		
	}

	public void close() {

		synchronized (stateLock) {

			if (null != channel ) {

				try {
					//发生关闭，阻塞到关闭完成
					ChannelFuture closeFuture = channel.close();
					closeFuture.addListener(new GenericFutureListener<Future<? super Void>>() {

						@Override
						public void operationComplete(
								Future<? super Void> future) throws Exception {
							for (INetCloseListener l : closeListeners) {
								l.onClose(NetServiceAdaptor.this.channel); 
							}
						}
					});
					closeFuture.sync();
					
					startListeners.clear();
					closeListeners.clear();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
