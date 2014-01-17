package evanq.game.net.packets;

import java.io.IOException;

import evanq.game.net.AbstractPacket;
import evanq.game.net.NetConnectionEvent;
import evanq.game.net.NetConnectionType;
import evanq.game.net.NetPacketType;
import evanq.game.net.io.DataReader;
import evanq.game.net.io.DataWriter;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class SRequestConnection_OK extends AbstractPacket {

	private byte connectionType;
	
	
	public SRequestConnection_OK() {
		super(NetPacketType.SERVER);
	}
	

	@Override
	public void execute() {
		
		NetConnectionType type = NetConnectionType.valueOf(connectionType);
		connection().connectionTypeChange(type);
		
		connection().fsm().fireEvent(NetConnectionEvent.AUTH_OK);
	}


	@Override
	public void writeObject(DataWriter out) throws IOException {
		out.writeByte(connectionType);
	}


	@Override
	public void readObject(DataReader reader) throws IOException {
		connectionType = reader.readByte();
	}


	public byte getConnectionType() {
		return connectionType;
	}


	public void setConnectionType(byte connectionType) {
		this.connectionType = connectionType;
	}


	@Override
	protected StringBuffer toStringBuffer() {
		StringBuffer b = new StringBuffer();
		b.append("type[").append(connectionType).append("]");
		b.append("hashCode[").append(hashCode()).append("]");
		return b;
	}

}
