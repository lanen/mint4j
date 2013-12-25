package evanq.game.client.net;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import evanq.game.net.NettyDecoder;
import evanq.game.net.NettyEncoder;

public class NettyClientInit extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast("beforDecoder", new LengthFieldBasedFrameDecoder(2048,0, 4));
		pipeline.addLast("lastEncoder", new LengthFieldPrepender(4));

		pipeline.addLast("decoder", new NettyDecoder());		
		pipeline.addLast("encoder", new NettyEncoder());

		// and then business logic.
		pipeline.addLast("handler", new NettyClientHandler());
	}

}
