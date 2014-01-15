package evanq.game.net.packets;

import java.io.IOException;

import evanq.game.net.AbstractPacket;
import evanq.game.net.NetPacketType;
import evanq.game.net.io.DataReader;
import evanq.game.net.io.DataWriter;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class SRequestConnection_OK extends AbstractPacket {

	public SRequestConnection_OK() {
		super(NetPacketType.SERVER);
	}
	

	@Override
	public void execute() {
		
	}


	@Override
	public void writeObject(DataWriter out) throws IOException {
		
	}


	@Override
	public void readObject(DataReader reader) throws IOException {
		
	}


	@Override
	protected StringBuffer toStringBuffer() {
		return null;
	}

}
