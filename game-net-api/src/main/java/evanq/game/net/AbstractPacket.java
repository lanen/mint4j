package evanq.game.net;

import java.io.IOException;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractPacket implements IPacket , Cloneable {

	public abstract void writeObject(OutputSerializer out) throws IOException;
	
	public abstract void readObject(InputSerializer in) throws IOException;
	
}
