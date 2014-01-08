package evanq.game.net;

public class AgentNetConnectionManager extends AbstractNetConnectionManager {

	/**
	 * 
	 * 保持所有来自服务器节点的连接
	 * 
	 */
	private AbstractNetConnectionHolder holdingServerNodeConnections;

	protected AgentNetConnectionManager(NetServiceType serviceType) {
		super(serviceType);
		// TODO Auto-generated constructor stub
	}



}
