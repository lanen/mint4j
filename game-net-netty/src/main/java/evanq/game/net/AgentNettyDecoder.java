package evanq.game.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class AgentNettyDecoder extends ByteToMessageDecoder {

	private AbstractPacketAllocator packetAllocator;
	
	public AgentNettyDecoder(AbstractPacketAllocator packetAllocator) {
		this.packetAllocator=packetAllocator;
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		
	}

}
