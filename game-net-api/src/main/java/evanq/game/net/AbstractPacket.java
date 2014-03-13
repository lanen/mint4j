package evanq.game.net;

import evanq.game.net.io.Serializable;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractPacket implements IPacket , Serializable {

	static class Struct{
		
		/**编解码器方式*/
		public byte codec;
		
		/** 是否压缩 */
		public byte zip;
		
		/** 是否加密 */
		public byte encrypt;
		
	}
	
	/**
	 * 数据包类型
	 */
	protected NetPacketType packetType;
	
	/**
	 * 数据包id，会更具这个id来决定编解码
	 */
	protected int packetId;
	
	/**
	 * 
	 * 当前数据包的来自哪个连接
	 * 
	 */
	private INetConnection connection;
	
	protected AbstractPacket(NetPacketType packetType){
		this.packetType = packetType;
	}

	public NetPacketType getPacketType() {
		return packetType;
	}

	protected void setPacketType(NetPacketType packetType) {
		this.packetType = packetType;
	}

	public int getPacketId() {
		return packetId;
	}

	public void setPacketId(int packetId) {
		this.packetId = packetId;
	}
	
	public AbstractNetConnection connection(){
		return (AbstractNetConnection)connection;
	}
	
	@Override
	public INetConnection connection(INetConnection nc) {
		this.connection=nc;
		return connection;
	}

	protected abstract StringBuffer toStringBuffer();
	
	public String toString(){
		StringBuffer b = new StringBuffer();
		b.append("[").append(packetType).append("]Packet[").append((int)packetId).append("] ").
		append(toStringBuffer());		
		return b.toString();
	}
}
