package evanq.game.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CodecException;

import java.util.List;

import evanq.game.net.io.InputSerializer;

public class NettyDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		
		System.out.println("NettyDecoder.decode() - readable bytes:"+in.readableBytes());
		if (! in.isReadable()) {
			return;
		}
		
		if (in.readableBytes()< 2) {			
			return;
		}
		int length = in.readInt();
		in.markReaderIndex();
		int commandKey = in.readChar();
		
		AbstractPacket newPacket = PacketAllocator.getInstance().newPacket(commandKey);
		
		if(null != newPacket){
			
			ByteBufInputStream os = new ByteBufInputStream(in);
			InputSerializer serializer = new InputSerializer(os);
			
			newPacket.readObject(serializer);
			
			out.add(newPacket);
		}else{
			in.resetReaderIndex();
			throw new CodecException("commandKey "+commandKey+" do not request");
		}
		
		
	}

}
