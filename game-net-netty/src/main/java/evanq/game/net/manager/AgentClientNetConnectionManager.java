package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionFSM;
import evanq.game.net.NetConnectionType;
import evanq.game.net.NetServiceType;

/**
 * 
 * 代理服务的连接管理
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class AgentClientNetConnectionManager extends AbstractNetConnectionManager {
	
	public AgentClientNetConnectionManager() {
		super(NetServiceType.AGENT_CLIENT);
	}

	@Override
	protected INetConnectionFSM createNetConnectionFSM(INetConnection connection) {
		ServerNetConnectionFSM fsm = new ServerNetConnectionFSM(this,connection);
		return fsm;
	}
	
}
