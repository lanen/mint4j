package evanq.game.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public final class Netty {
	
	private int port;
	
	public Netty(int port) {
		
		if(port<1024 || port > 63365){
			throw new IllegalArgumentException("端口控制在1024-63365之间");
		}
	
		this.port = port;
	}

	public void initNettyAcceptor(){
		
		//绑定数据包
		PacketAllocator.getInstance().doRegister();
		
		
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		try {
			
			ServerBootstrap boot = new ServerBootstrap();
			boot.group(bossGroup, workGroup).
			channel(NioServerSocketChannel.class).
			childHandler(new NettyServerInitializer());
			
			boot.bind(this.port).sync().channel().closeFuture().sync();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
	
	
	public static void main(String[] args) {
		
		Netty ny = new Netty(10000);
		ny.initNettyAcceptor();
		
	}
}
