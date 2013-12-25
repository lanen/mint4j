package evanq.game.net.io;

import java.io.IOException;

public interface Output {

	public void write(int b) throws IOException;
	
	public void write(byte b[]) throws IOException ;
	
	public void write(byte b[], int off, int len) throws IOException;
	
	public void write(byte b) throws IOException ;
	
	public void write(float b) throws IOException ;
	
	public void write(double b) throws IOException ;
	
	public void write(long b) throws IOException ;
	
	public void write(String b) throws IOException ;

}
