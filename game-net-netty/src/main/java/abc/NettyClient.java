package abc;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import evanq.game.net.netty.FactorialClientHandler;

public class NettyClient {

    public void run() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .handler(new NettyClientInit());

            // Make a new connection.
            ChannelFuture f = b.connect("127.0.0.1", 8081).sync();

            // Get the handler instance to retrieve the answer.
            FactorialClientHandler handler =
                (FactorialClientHandler) f.channel().pipeline().last();

        } finally {
            group.shutdownGracefully();
        }
    }
	public static void main(String[] args) throws Exception {
		
		NettyClient client = new NettyClient();
		client.run();
		
	}
}
