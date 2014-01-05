package evanq.game.net.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import evanq.game.net.DefaultNettyDecoder;
import evanq.game.net.DefaultNettyEncoder;
@Deprecated

public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast("beforDecoder", new LengthFieldBasedFrameDecoder(2048,0, 4));
		pipeline.addLast("lastEncoder", new LengthFieldPrepender(4));

		pipeline.addLast("decoder", new DefaultNettyDecoder());		
		pipeline.addLast("encoder", new DefaultNettyEncoder());

		// and then business logic.
		pipeline.addLast("handler", new NettyClientHandler());
	}

}
