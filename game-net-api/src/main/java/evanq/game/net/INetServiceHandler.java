package evanq.game.net;

public interface INetServiceHandler {

	/**
	 * 数据包
	 * 
	 * @return
	 */
	public AbstractPacketAllocator packetAllocator();
	
	/**
	 * 连接管理器
	 * 
	 * @return
	 */
	public INetConnectionManager netConnectionManager();
}
