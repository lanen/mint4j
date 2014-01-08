package evanq.game.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class AgentNettyEncoder extends MessageToByteEncoder<AbstractPacket> {

	@Override
	protected void encode(ChannelHandlerContext ctx, AbstractPacket msg,
			ByteBuf out) throws Exception {
		
	}

}
