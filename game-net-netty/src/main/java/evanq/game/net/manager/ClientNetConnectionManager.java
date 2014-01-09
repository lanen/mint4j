package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.NetServiceType;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;

/**
 * 
 * 作为客户端连接持有的，管理本身的连接管理器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class ClientNetConnectionManager extends AbstractNetConnectionManager {

	
	private Trace logger = LogSystem.getDefaultTrace(ClientNetConnectionManager.class);
	
	
	public ClientNetConnectionManager() {
		super(NetServiceType.CLIENT);
	}
	
	@Override
	public void accpet(INetConnection connection) {
		logger.info("完成连接创建");
		
	}

	@Override
	public void close(INetConnection connection) {
		logger.info("关闭连接");

	}

}
