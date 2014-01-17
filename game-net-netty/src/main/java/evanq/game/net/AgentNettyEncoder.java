package evanq.game.net;

import evanq.game.net.io.DefaultDataWriter;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class AgentNettyEncoder extends MessageToByteEncoder<AbstractPacket> {

	@Override
	protected void encode(ChannelHandlerContext ctx, AbstractPacket msg,
			ByteBuf out) throws Exception {
		System.out.println("AgentNettyEncoder.encode()");
//		ByteBufOutputStream os = new ByteBufOutputStream(out);
//		os.writeChar(msg.getPacketId());
//		
//		DefaultDataWriter writer = new DefaultDataWriter(os);
//		
//		msg.writeObject(writer);
//		
//		//TODO 了解Netty的Flush 机制。控制单位时间的flush频率。
//		
//		ctx.writeAndFlush(out);
	
	}

}
