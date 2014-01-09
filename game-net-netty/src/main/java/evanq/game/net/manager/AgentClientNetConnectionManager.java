package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.NetServiceType;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;

/**
 * 
 * 代理服务的连接管理
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class AgentClientNetConnectionManager extends AbstractNetConnectionManager {
	
	private Trace logger = LogSystem.getDefaultTrace(AgentClientNetConnectionManager.class);

	public AgentClientNetConnectionManager() {
		super(NetServiceType.AGENT_CLIENT);
	}

	@Override
	public void accpet(INetConnection connection) {
		logger.info("接受到来自客户端的连接");
	}

	@Override
	public void close(INetConnection connection) {
		logger.info("关闭客户端连接");
	}
	
}
