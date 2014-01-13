package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionFSM;
import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionFSM;
import evanq.game.net.NetConnectionEvent;
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

	/*

	@Override
	public void accpet(INetConnection connection) {
		
		//TODO 一旦连接建立，遍给他建立一个状态机。
		//不同类型的连接，可能需要不同的状态机来管理，这里可以拓展
		
		switch(this.serviceType){
		case AGENT_CLIENT:
			System.out.println("网关 用于管理来自客户端的连接管理器");
			break;
		case AGENT_SERVER:
			System.out.println("网关 用于管理来自服务端的连接管理器");
			break;
		case SERVER:
			System.out.println("服务端的连接管理器");
			break;
		case CLIENT:
			System.out.println("客户端的连接管理器");
			break;
		}
		
	}
	
	*/

}
