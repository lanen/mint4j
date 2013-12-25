package evanq.game.net;

import evanq.game.net.io.Serializable;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractPacket implements IPacket , Serializable {

	/**
	 * 数据包类型
	 */
	protected char packetType;
	
	/**
	 * 数据包id，会更具这个id来决定编解码
	 */
	protected char packetId;
	
	/**
	 * 
	 * 当前数据包的来自哪个连接
	 * 
	 */
	private INetConnection connection;
	
	protected AbstractPacket(char packetType){
		this.packetType = packetType;
	}

	public char getPacketType() {
		return packetType;
	}

	public void setPacketType(char packetType) {
		this.packetType = packetType;
	}

	public char getPacketId() {
		return packetId;
	}

	public void setPacketId(char packetId) {
		this.packetId = packetId;
	}
	
	public AbstractNetConnection connection(){
		return (AbstractNetConnection)connection;
	}
	
	protected abstract StringBuffer toStringBuffer();
	
	public String toString(){
		StringBuffer b = new StringBuffer();
		b.append("[").append(packetType).append("]Packet[").append((int)packetId).append("] ").
		append(toStringBuffer());		
		return b.toString();
	}
}
