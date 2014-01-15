package evanq.game.net.sapi;

import evanq.game.net.INetService;
import evanq.game.net.NetConnectionType;


/**
 * @author Evan cppmain@gmail.com
 *
 */
public interface INetServiceFactory {
	
	/**
	 * 
	 * 获取监听指定端口的服务
	 * 
	 * @param port
	 * @return
	 */
	public INetService getNetService(int port);
	
	/**
	 * 
	 * 用于创建特定类型的客户端连接
	 * 
	 * @param connectionType
	 * @param host
	 * @param port
	 * @return
	 */
	public INetService getNetService(NetConnectionType connectionType, String host, int port);
	
}
