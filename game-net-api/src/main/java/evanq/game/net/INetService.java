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
	 * @return
	 */
	public NetServiceType serviceTye();
	
	
	//public void route(IPacket packet);
}
