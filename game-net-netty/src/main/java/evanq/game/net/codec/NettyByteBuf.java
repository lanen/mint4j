package evanq.game.net.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.ByteBufUtil;

import java.io.IOException;

public class NettyByteBuf implements Input , Output{

	public NettyByteBuf(){
		
	}
	
	private ByteBuf buf;
	
	public NettyByteBuf(ByteBuf buf) {
		this.buf = null;
	}
	
	@Override
	public int read() throws IOException {
		return buf.readByte();
	}

	@Override
	public int read(byte[] b) throws IOException {
		if(null == b){
			throw new NullPointerException("b");
		}
		buf.readBytes(b);
		return b.length>=0 ? b.length:-1;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		if(null == b){
			throw new NullPointerException("b");
		}
		buf.readBytes(b, off, len);
		return b.length>=0 ? b.length:-1;
	}

	@Override
	public byte readByte() throws IOException {		
		return buf.readByte();
	}

	@Override
	public short readShort() throws IOException {
		return buf.readShort();
	}

	@Override
	public int readInt() throws IOException {
		return buf.readInt();
	}

	@Override
	public float readFloat() throws IOException {
		return buf.readFloat();
	}

	@Override
	public long readLong() throws IOException {
		return buf.readLong();
	}

	@Override
	public double readDouble() throws IOException {
		return buf.readDouble();
	}

	@Override
	public void write(int b) throws IOException {
		buf.writeInt(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		buf.writeBytes(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		buf.writeBytes(b, off, len);
	}

	@Override
	public void write(byte b) throws IOException {
		buf.writeByte(b);
	}

	@Override
	public void write(float b) throws IOException {
		buf.writeFloat(b);
	}

	@Override
	public void write(String b) throws IOException {
		buf.writeBytes(b.getBytes("UTF-8"));
	}

	@Override
	public void write(double b) throws IOException {
		buf.writeDouble(b);
	}

	@Override
	public void write(long b) throws IOException {
		buf.writeLong(b);
	}

	
}
