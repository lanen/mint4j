package evanq.game.net.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * InputSerializer is used to serialize classes that implement the Serializable
 * interface from an InputStream.
 */
public class InputSerializer {

	private InputStream in;
	
	private int protocolVersion = 1;


	/**
	 * Constructor that passes the InputStream to the serializer
	 *
	 * @param in
	 *            the InputStream
	 */
	public InputSerializer(InputStream in) {
		this.in = in;
	}

	/**
	 * This method serializes an object that implements the interface
	 * Serializable, allowing to implement this behaviour in several classes
	 *
	 * @param obj
	 *            the object where we will serialize the data
	 * @return the object serialized, just for interface coherence
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public Object readObject(Serializable obj) throws IOException {
		obj.readObject(this);
		return obj;
	}

	/**
	 * This method reads a byte from the Serializer
	 *
	 * @return the byte serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public byte readByte() throws IOException {
		int result = in.read();

		if (result < 0) {
			throw new IOException();
		}
		return (byte) result;
	}

	/**
	 * This method reads a byte array from the Serializer
	 *
	 * @return the byte array serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public byte[] readByteArray() throws IOException {
		int size = readInt();
//
//		if (size > TimeoutConf.MAX_BYTE_ARRAY_ELEMENTS) {
//			throw new IOException("Illegal request of an array of " + size + " size");
//		}

		byte[] buffer = new byte[size];
		
		int bytes_read_total = 0;
		int bytes_read = 0;
		
		while ((bytes_read_total < size)
		        && (bytes_read = in.read(buffer, bytes_read_total, size - bytes_read_total)) != -1) {
			bytes_read_total += bytes_read;
		}
		if (bytes_read_total != size) {
			throw new IOException("Declared array size=" + size
			        + " is not equal to actually read bytes count(" + bytes_read_total + ")!");
		}
		
		return buffer;
	}

	/**
	 * converts a byte into an int of range 0-255
	 *
	 * @param b byte to convert
	 * @return int in range 0-255
	 */
	private static int byteToPositiveInt(byte b) { 
		return b & 0xff; 
	}

	/**
	 * This method reads a byte array of a maximum length of 255 entries
	 *
	 * @return the byte array serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public byte[] read255LongByteArray() throws IOException {
		int size = byteToPositiveInt(readByte());

		byte[] buffer = new byte[size];
//		in.get(buffer);
		int bytes_read_total = 0;
		int bytes_read = 0;

		while ((bytes_read_total < size)
		        && (bytes_read = in.read(buffer, bytes_read_total, size - bytes_read_total)) != -1) {
			bytes_read_total += bytes_read;
		}
		if (bytes_read_total != size) {
			throw new IOException("Declared array size=" + size
			        + " is not equal to actually read bytes count(" + bytes_read_total + ")!");
		}
		return buffer;
	}

	/**
	 * This method reads a byte array of a maximum length of 65536 entries
	 *
	 * @return the byte array serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public byte[] read65536LongByteArray() throws IOException {
		int size = readShort();

		if (size < 0) {
			throw new IOException("Illegal request of an array of " + size + " size");
		}

		byte[] buffer = new byte[size];
//		in.get(buffer);
		int bytes_read_total = 0;
		int bytes_read = 0;

		while ((bytes_read_total < size)
		        && (bytes_read = in.read(buffer, bytes_read_total, size - bytes_read_total)) != -1) {
			bytes_read_total += bytes_read;
		}
		if (bytes_read_total != size) {
			throw new IOException("Declared array size=" + size
			        + " is not equal to actually read bytes count(" + bytes_read_total + ")!");
		}
		return buffer;
	}

	/**
	 * This method reads a short from the Serializer
	 *
	 * @return the short serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public short readShort() throws IOException {
		int size = 2;
		byte[] data = new byte[size];
//		in.get(data);
		int bytes_read_total = 0;
		int bytes_read = 0;

		while ((bytes_read_total < size)
		        && (bytes_read = in.read(data, bytes_read_total, size - bytes_read_total)) != -1) {
			bytes_read_total += bytes_read;
		}
		if (bytes_read_total != size) {
			throw new IOException("Declared array size=" + size
			        + " is not equal to actually read bytes count(" + bytes_read_total + ")!");
		}

		int result = data[0] & 0xFF;

		result += (data[1] & 0xFF) << 8;
		return (short) result;
	}

	/**
	 * This method reads a int from the Serializer
	 *
	 * @return the int serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public int readInt() throws IOException {
		int size = 4;
		byte[] data = new byte[size];
//		in.get(data);
		int bytes_read_total = 0;
		int bytes_read = 0;
		
		while ((bytes_read_total < size)
		        && (bytes_read = in.read(data, bytes_read_total, size - bytes_read_total)) != -1) {
			bytes_read_total += bytes_read;
		}
		if (bytes_read_total != size) {
			throw new IOException("Declared array size=" + size
			        + " is not equal to actually read bytes count(" + bytes_read_total + ")!");
		}

//		int result = data[0] & 0xFF;
//
//		result += (data[1] & 0xFF) << 8;
//		result += (data[2] & 0xFF) << 16;
//		result += (data[3] & 0xFF) << 24;
		return bytesToInt(data);
	}
	
	/**
	 * This method reads a float from the Serializer
	 *
	 * @return the float serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public float readFloat() throws IOException {
		int size = 4;
		byte[] data = new byte[size];
//		in.get(data);
		int bytes_read_total = 0;
		int bytes_read = 0;

		while ((bytes_read_total < size)
		        && (bytes_read = in.read(data, bytes_read_total, size - bytes_read_total)) != -1) {
			bytes_read_total += bytes_read;
		}
		if (bytes_read_total != size) {
			throw new IOException("Declared array size=" + size
			        + " is not equal to actually read bytes count(" + bytes_read_total + ")!");
		}

		int result = data[0] & 0xFF;

		result += (data[1] & 0xFF) << 8;
		result += (data[2] & 0xFF) << 16;
		result += (data[3] & 0xFF) << 24;
		return Float.intBitsToFloat(result);
	}

	/**
	 * This method reads a String from the Serializer
	 *
	 * @return the String serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public String readString() throws IOException {
		return new String(readByteArray(), "UTF-8");
	}

	/**
	 * This method reads a short string (whose size is smaller than 255 bytes
	 * long)
	 *
	 * @return the String serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public String read255LongString() throws IOException {
		return new String(read255LongByteArray(), "UTF-8");
	}

	/**
	 * This method reads a long string (whose size is smaller than 65536 bytes
	 * long)
	 *
	 * @return the String serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public String read65536LongString() throws IOException {
		return new String(read65536LongByteArray(), "UTF-8");
	}

	/**
	 * This method reads a String array from the Serializer
	 *
	 * @return the String array serialized
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public String[] readStringArray() throws IOException {
		int size = readInt();

//		if (size > TimeoutConf.MAX_ARRAY_ELEMENTS) {
//			throw new IOException("Illegal request of an array of " + String.valueOf(size) + " size");
//		}

		String[] buffer = new String[size];

		for (int i = 0; i < size; i++) {
			buffer[i] = readString();
		}
		return buffer;
	}

	/**
	 * This method reads a String array from the Serializer
	 *
	 * @param clazz class of the object
	 * @return the object array
	 * @throws java.io.IOException
	 *             if there is an IO error
	 */
	public Object[] readObjectArray(Class<? extends Serializable> clazz) throws IOException {
		int size = readInt();
//
//		if (size > TimeoutConf.MAX_ARRAY_ELEMENTS) {
//			throw new IOException("Illegal request of an array of " + String.valueOf(size) + " size");
//		}

		Object[] buffer = new Object[size];

		for (int i = 0; i < size; i++) {
			Serializable object;
            try {
	            object = clazz.newInstance();
            } catch (InstantiationException e) {
	            throw new IOException(e.toString());
            } catch (IllegalAccessException e) {
	            throw new IOException(e.toString());
            }
			buffer[i] = readObject(object);
		}
		return buffer;
	}

	/**
	 * gets the protocolVersion
	 *
	 * @return protocol version
	 */
	public int getProtocolVersion() {
    	return protocolVersion;
    }

	/**
	 * sets the protocol version
	 *
	 * @param protocolVersion protocol version
	 */
	public void setProtocolVersion(int protocolVersion) {
    	this.protocolVersion = protocolVersion;
    }

	private int  bytesToInt(byte[] data){
		return (data[0] & 0xFF) + ((data[1] & 0xFF) << 8) + ((data[2] & 0xFF) << 16)
		        + ((data[3] & 0xFF) << 24);
	}
}
