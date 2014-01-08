package evanq.game.net;

/**
 * 
 * 网络IO 服务的抽象
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface INetService {

	/**
	 * 开始服务
	 */
	public void open();
	
	/**
	 * 关闭服务
	 */
	public void close();
		
	
	/**
	 * 
	 * 要求发送数据
	 * 
	 * @param packet
	 */
	public void send(IPacket packet);
	
	/**
	 * 要求接受数据
	 * 这里概念模糊
	 * @param packet
	 */
	public void receive(IPacket packet);
	
	/**
	 * 
	 * @return
	 */
	public NetServiceType serviceTye();
	
	
	//public void route(IPacket packet);
}
