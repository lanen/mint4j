package evanq.game.net.packets;

import java.io.IOException;

import evanq.game.net.AbstractPacket;
import evanq.game.net.NetConnectionEvent;
import evanq.game.net.NetConnectionType;
import evanq.game.net.NetPacketType;
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

	/** 客户端的连接类型 */
	private byte connectionType;
	
	private long accessToken;
	
	public CRequestConnection(){
		super(NetPacketType.CLIENT);
	}
	
	@Override
	public void execute() {
		
		NetConnectionType type = NetConnectionType.valueOf(connectionType);
		connection().connectionTypeChange(type);
		
		//返回验证成功
		SRequestConnection_OK ok = new SRequestConnection_OK();
		ok.setConnectionType(connectionType);
		ok.setPacketId(PacketConst.S_CONNECT_REQUEST_OK);
		connection().send(ok);
				
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
