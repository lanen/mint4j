package evanq.game.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class NettyEncoder extends MessageToByteEncoder<AbstractPacket> {

	@Override
	protected void encode(ChannelHandlerContext ctx, AbstractPacket msg, ByteBuf out)
			throws Exception {
		
		ByteBufOutputStream os = new ByteBufOutputStream(out);
		
		OutputSerializer outputSerializer = new OutputSerializer(os);
		
		msg.writeObject(outputSerializer);
		
		ctx.write(out);
	}

}
