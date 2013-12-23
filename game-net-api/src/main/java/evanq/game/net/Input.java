package evanq.game.net;

import java.io.IOException;

public interface Input {
	
	public int read() throws IOException;
	
	public int read(byte b[]) throws IOException ;
	
	public int read(byte b[], int off, int len) throws IOException;
	
	public byte readByte() throws IOException;
	
	public short readShort() throws IOException ;
	
	public int readInt() throws IOException;
	
	public long readLong() throws IOException;
	
	public double readDouble() throws IOException;
	
	public float readFloat() throws IOException ;
	
}
