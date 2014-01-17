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
	 * 网络设别的服务类型
	 * @return
	 */
	public NetServiceType serviceTye();
	
	/**
	 * 连接的类型
	 * 
	 * @return
	 */
	public NetConnectionType connectionType();
	

}
