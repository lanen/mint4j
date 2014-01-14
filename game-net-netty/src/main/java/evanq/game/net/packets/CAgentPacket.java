package evanq.game.net.packets;

import java.io.IOException;

import evanq.game.net.AbstractPacket;
import evanq.game.net.PacketConst;
import evanq.game.net.io.DataReader;
import evanq.game.net.io.DataWriter;

public class CAgentPacket extends AbstractPacket {

	
	public CAgentPacket() {
		super(PacketConst.PACKET_TYPE_CLIENT);
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeObject(DataWriter out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readObject(DataReader reader) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected StringBuffer toStringBuffer() {
		// TODO Auto-generated method stub
		return null;
	}

}
