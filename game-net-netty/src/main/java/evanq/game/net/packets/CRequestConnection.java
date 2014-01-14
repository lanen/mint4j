package evanq.game.net.packets;

import java.io.IOException;

import evanq.game.net.AbstractPacket;
import evanq.game.net.NetConnectionEvent;
import evanq.game.net.NetConnectionType;
import evanq.game.net.PacketConst;
import evanq.game.net.io.DataReader;
import evanq.game.net.io.DataWriter;

/**
 * 客户端请求链接
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class CRequestConnection extends AbstractPacket {

	private byte connectionType;
	
	private long accessToken;
	
	public CRequestConnection(){
		super(PacketConst.PACKET_TYPE_CLIENT);
	}
	
	
	@Override
	public void execute() {
		
		//step 1. 从accessToken 中获取账号
		
		NetConnectionType type = NetConnectionType.valueOf(connectionType);
		connection().type(type);
		connection().fsm().fireEvent(NetConnectionEvent.AUTH_OK);		

		//step 2. get connection holder by session key
		//step 3. notify connection manager
	}

	@Override
	public void writeObject(DataWriter out) throws IOException {
		out.write(connectionType);
		out.writeLong(accessToken);
	}

	@Override
	public void readObject(DataReader reader) throws IOException {
		connectionType=reader.readByte();
		accessToken   = reader.readLong();
	}

	@Override
	protected StringBuffer toStringBuffer() {
		StringBuffer b = new StringBuffer();
		b.append("type[").append(connectionType).append("]");
		b.append("accessToken[").append(accessToken).append("]");
		b.append("hashCode[").append(hashCode()).append("]");
		return b;
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

	public void setAccessToken(long accessToken) {
		this.accessToken = accessToken;
	}
	
}
