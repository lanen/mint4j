package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionFSM;
import evanq.game.net.NetServiceType;

/**
 * 网关方面，用于管理来自节点的连接管理器
 * @author Evan cppmain@gmail.com
 *
 */
public final class AgentServerNetConnectionManager extends
		AbstractNetConnectionManager {

	public AgentServerNetConnectionManager() {
		super(NetServiceType.AGENT_SERVER);
	}
	
	@Override
	protected INetConnectionFSM createNetConnectionFSM(INetConnection connection) {
		ServerNetConnectionFSM fsm = new ServerNetConnectionFSM(this, connection);

		return fsm;
	}	

}
