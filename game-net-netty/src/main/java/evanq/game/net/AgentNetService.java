package evanq.game.net;

/**
 * 
 * 建立一个代理类型的服务器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class AgentNetService extends NetServiceAdaptor {

	public AgentNetService(NetServiceType serviceType, int port,
			INetServiceHandler handler) {
		super(serviceType, port, handler);
		// TODO Auto-generated constructor stub
	}

	public AgentNetService(NetServiceType serviceType, String host, int port,
			INetServiceHandler handler,
			AbstractNettyInitializer nettyInitializer) {
		super(serviceType, host, port, handler, nettyInitializer);
		// TODO Auto-generated constructor stub
	}

	public AgentNetService(NetServiceType serviceType, String host, int port,
			INetServiceHandler handler) {
		super(serviceType, host, port, handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AbstractNettyInitializer newNettyInitializer() {
		return new AgentNettyInitializer(null, null);
	}
	
	
}
