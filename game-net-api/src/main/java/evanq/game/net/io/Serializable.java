package evanq.game.net.io;

import java.io.IOException;

/**
 * Interface of all the object that wants to be able to be converted into a
 * stream of bytes.
 */
public interface Serializable {

	/**
	 * Method to convert the object into a stream
	 *
	 * @param out OutputSerializer to write the object to
	 * @throws IOException in case of an IO-error
	 */
	void writeObject(DataWriter out) throws java.io.IOException;

	/** 
	 * Method to build the object from a stream of bytes
	 *
	 * @param in InputSerializer to read from
	 * @throws IOException in case of an IO-error
	 */
	void readObject(DataReader reader) throws java.io.IOException;
}
