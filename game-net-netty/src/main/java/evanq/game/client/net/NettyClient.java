package evanq.game.client.net;

import evanq.game.net.PacketAllocator;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public void run() throws Exception {
    	
    	PacketAllocator.getInstance().doRegister();
    	
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)             
             .handler(new NettyClientInit());

            // Make a new connection.
            ChannelFuture connect = b.connect("127.0.0.1", 10000);
            connect.sync();
         //   connect.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
	public static void main(String[] args) throws Exception {
		
		NettyClient client = new NettyClient();
		client.run();
		
	}
}
