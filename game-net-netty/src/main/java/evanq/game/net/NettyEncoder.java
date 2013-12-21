package evanq.game.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

class NettyEncoder extends MessageToByteEncoder<Void> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Void msg, ByteBuf out)
			throws Exception {
		
	}

}
