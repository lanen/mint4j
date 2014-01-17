package evanq.game.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import evanq.game.net.io.DefaultDataWriter;

public class DefaultNettyEncoder extends MessageToByteEncoder<AbstractPacket> {
	
	public DefaultNettyEncoder() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void encode(ChannelHandlerContext ctx, AbstractPacket msg, ByteBuf out)
			throws Exception {
		
		ByteBufOutputStream os = new ByteBufOutputStream(out);
		os.writeChar(msg.getPacketId());
		
		DefaultDataWriter writer = new DefaultDataWriter(os);
		
		msg.writeObject(writer);
		
		//TODO 了解Netty的Flush 机制。控制单位时间的flush频率。
		
		ctx.writeAndFlush(out);
		//ctx.write(out);
	}

}
