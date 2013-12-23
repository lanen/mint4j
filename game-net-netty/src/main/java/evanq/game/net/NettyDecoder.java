package evanq.game.net;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class NettyDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		
		System.out.println("NettyDecoder.decode()");
		
		
		int commandKey = in.readInt();
		//opcode 
		
		Class<?> class1 = CommandOpcode.clazz.get(commandKey);
		
		ByteBufInputStream os = new ByteBufInputStream(in);
		InputSerializer serializer = new InputSerializer(os);
			
		AbstractPacket newInstance =(AbstractPacket) class1.newInstance();
		newInstance.readObject(serializer);
		
		out.add(newInstance);
		
		
	}

}
