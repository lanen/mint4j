package abc;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import evanq.game.net.NettyDecoder;
import evanq.game.net.NettyEncoder;

public class NettyClientInit extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		pipeline.addLast("decoder", new NettyDecoder());		
		pipeline.addLast("encoder", new NettyEncoder());

		// and then business logic.
		pipeline.addLast("handler", new NettyClientHandler());
	}

}
