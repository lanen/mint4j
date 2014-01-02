package evanq.game.net.packets;

import java.io.IOException;

import evanq.game.net.AbstractPacket;
import evanq.game.net.PacketConst;
import evanq.game.net.io.InputSerializer;
import evanq.game.net.io.OutputSerializer;

/**
 * 客户端请求链接
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class CRequestConnection extends AbstractPacket {

	private byte connectionType;
	
	public CRequestConnection(){
		super(PacketConst.PACKET_TYPE_CLIENT);
	}
	
	
	
	@Override
	public void execute() {
		System.out.println("CRequestConnection.execute() - "+ connection());		
		
	}


	@Override
	public void writeObject(OutputSerializer out) throws IOException {
		out.write(connectionType);
	}

	@Override
	public void readObject(InputSerializer in) throws IOException {
		connectionType=in.readByte();
	}



	@Override
	protected StringBuffer toStringBuffer() {
		return null;
	}


	public byte getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(byte connectionType) {
		this.connectionType = connectionType;
	}


}