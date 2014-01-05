package evanq.game.net.packets;

import java.io.IOException;

import evanq.game.net.AbstractPacket;
import evanq.game.net.NetConnectionEvent;
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
	
	private int accessToken;
	
	public CRequestConnection(){
		super(PacketConst.PACKET_TYPE_CLIENT);
	}
	
	
	
	@Override
	public void execute() {
		System.out.println("CRequestConnection.execute() - "+ connection());		
		//step 1. 从accessToken 中获取账号
		connection().fsm().fireEvent(NetConnectionEvent.AUTH_OK);
		//step 2. get connection holder by session key
		//step 3. notify connection manager
	}


	@Override
	public void writeObject(OutputSerializer out) throws IOException {
		out.write(connectionType);
		out.write(accessToken);
	}

	@Override
	public void readObject(InputSerializer in) throws IOException {
		connectionType=in.readByte();
		accessToken = in.readInt();
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

	public long getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(int accessToken) {
		this.accessToken = accessToken;
	}

	
}
