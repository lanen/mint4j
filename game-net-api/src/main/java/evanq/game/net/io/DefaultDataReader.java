package evanq.game.net.io;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DefaultDataReader implements DataReader {

	private DataInput input;
	
	public DefaultDataReader(InputStream in) {
		this.input = new DataInputStream(in);
	}
	
	
	@Override
	public void readFully(byte[] b) throws IOException {
		input.readFully(b);
	}

	@Override
	public void readFully(byte[] b, int off, int len) throws IOException {
		input.readFully(b, off, len);
	}

	@Override
	public int skipBytes(int n) throws IOException {
		return input.skipBytes(n);
	}

	@Override
	public boolean readBoolean() throws IOException {
		return input.readBoolean();
	}

	@Override
	public byte readByte() throws IOException {
		return input.readByte();
	}

	@Override
	public int readUnsignedByte() throws IOException {
		return input.readUnsignedByte();
	}

	@Override
	public short readShort() throws IOException {
		return input.readShort();
	}

	@Override
	public int readUnsignedShort() throws IOException {
		return input.readUnsignedShort();
	}

	@Override
	public char readChar() throws IOException {
		return input.readChar();
	}

	@Override
	public int readInt() throws IOException {
		return input.readInt();
	}

	@Override
	public long readLong() throws IOException {
		return input.readLong();
	}

	@Override
	public float readFloat() throws IOException {
		return input.readFloat();
	}

	@Override
	public double readDouble() throws IOException {
		return input.readDouble();
	}

	@Override
	public String readLine() throws IOException {
		return input.readLine();
	}

	@Override
	public String readUTF() throws IOException {
		return input.readUTF();
	}

}
