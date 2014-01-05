package evanq.game.net.packets;

import java.io.IOException;

import evanq.game.net.AbstractPacket;
import evanq.game.net.PacketConst;
import evanq.game.net.io.InputSerializer;
import evanq.game.net.io.OutputSerializer;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class SRequestConnection_OK extends AbstractPacket {

	public SRequestConnection_OK() {
		super(PacketConst.PACKET_TYPE_SERVER);
	}
	

	@Override
	public void execute() {
		
	}

	@Override
	public void writeObject(OutputSerializer out) throws IOException {
		
	}

	@Override
	public void readObject(InputSerializer in) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected StringBuffer toStringBuffer() {
		return null;
	}

}
