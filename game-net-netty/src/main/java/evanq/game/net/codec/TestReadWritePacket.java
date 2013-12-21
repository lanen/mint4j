package evanq.game.net.codec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import evanq.net.packet.ClientPacket;

public class TestReadWritePacket {

	
	public static class One extends ClientPacket{
	
		public String aString;
		public int aInt;
		public byte aByte ;
		
		@Override
		public void writeObject(OutputSerializer out) throws IOException {
			out.write(aString);
			out.write(aInt);
			out.write(aByte);
		}

		@Override
		public void readObject(InputSerializer in) throws IOException {
			aString= in.readString();
			aInt=in.readInt();
			aByte=in.readByte();
		}

		@Override
		public void handleImpl() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {

		One one = new One();
		one.aString = "aaaa";
		one.aInt=100;
		one.aByte=1;
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputSerializer serializer = new OutputSerializer(baos);
		
		try {
			one.writeObject(serializer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] byteArray = baos.toByteArray();
		
		
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		InputSerializer is = new InputSerializer(bais);
		One stuff = new One();
		try {
			stuff.readObject(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(stuff.aString);
		System.out.println(stuff.aInt);
		System.out.println(stuff.aByte);
	}
}
