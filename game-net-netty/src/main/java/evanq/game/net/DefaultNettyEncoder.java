package evanq.game.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import evanq.game.net.io.OutputSerializer;

public class DefaultNettyEncoder extends MessageToByteEncoder<AbstractPacket> {

	@Override
	protected void encode(ChannelHandlerContext ctx, AbstractPacket msg, ByteBuf out)
			throws Exception {
		
		ByteBufOutputStream os = new ByteBufOutputStream(out);
		os.writeChar(msg.getPacketId());
		
		OutputSerializer outputSerializer = new OutputSerializer(os);
		
		msg.writeObject(outputSerializer);
		
		//TODO 了解Netty的Flush 机制。控制单位时间的flush频率。
		
		ctx.writeAndFlush(os);
	}

}
