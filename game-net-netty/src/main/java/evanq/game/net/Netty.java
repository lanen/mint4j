package evanq.game.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Netty {

	public void initNettyAcceptor(){
		
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		ServerBootstrap boot = new ServerBootstrap();
		boot.group(bossGroup, workGroup).channel(NioServerSocketChannel.class);
		
		boot.childHandler(new NettyServerInitializer());
		
		boot.bind(8081);
		
	}
	
	
	public static void main(String[] args) {
		
		
		Netty ny = new Netty();
		ny.initNettyAcceptor();
		
	}
}
