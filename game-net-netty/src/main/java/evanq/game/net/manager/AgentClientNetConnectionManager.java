package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionFSM;
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
	protected INetConnectionFSM createNetConnectionFSM(INetConnection connection) {
		ServerNetConnectionFSM fsm = new ServerNetConnectionFSM(this,connection);
		return fsm;
	}
	
}
