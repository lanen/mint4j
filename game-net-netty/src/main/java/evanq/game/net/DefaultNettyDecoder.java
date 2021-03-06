package evanq.game.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CodecException;

import java.util.List;

import evanq.game.net.io.DefaultDataReader;

public class DefaultNettyDecoder extends ByteToMessageDecoder {
	
	private AbstractPacketAllocator packetAllocator;

	public DefaultNettyDecoder(AbstractPacketAllocator packetAllocator) {
		
		this.packetAllocator = packetAllocator;
		
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {

		if (in.readableBytes() < 4) {
			return;
		}

		in.markReaderIndex();
		int length = in.readInt();

		if (in.readableBytes() < length) {
			in.resetReaderIndex();
			return;
		}
		/////////////////////////////////
		
		int commandKey = in.readChar();

		AbstractPacket newPacket = this.packetAllocator.newPacket(commandKey);

		if (null == newPacket) {
			throw new CodecException("commandKey " + commandKey
					+ " do not request");
		}
	
		ByteBufInputStream os = new ByteBufInputStream(in);

		DefaultDataReader reader = new DefaultDataReader(os);	
		
		newPacket.readObject(reader);
		
		out.add(newPacket);

	}

}
