package evanq.game.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public final class Netty {

	public void initNettyAcceptor(){
		
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		try {
			
			ServerBootstrap boot = new ServerBootstrap();
			boot.group(bossGroup, workGroup).
			channel(NioServerSocketChannel.class).
			childHandler(new NettyServerInitializer());
			
			boot.bind(10000).sync().channel().closeFuture().sync();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
	
	
	public static void main(String[] args) {
		
		
		Netty ny = new Netty();
		ny.initNettyAcceptor();
		
	}
}
