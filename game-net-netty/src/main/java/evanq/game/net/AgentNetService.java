package evanq.game.net;

/**
 * 
 * 建立一个代理类型的服务器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class AgentNetService extends NetServiceAdaptor {
	
	public AgentNetService(NetServiceType type, int port,
			INetConnectionManager netManager,
			AbstractPacketAllocator packetAllocator) {
		super(type, port, netManager, packetAllocator);
	}

	public AgentNetService(NetServiceType type, String host, int port,
			INetConnectionManager netManager,
			AbstractNettyInitializer nettyInitializer,
			AbstractPacketAllocator packetAllocator) {
		super(type, host, port, netManager, nettyInitializer, packetAllocator);
	}

	public AgentNetService(NetServiceType type, String host, int port,
			INetConnectionManager netManager,
			AbstractPacketAllocator packetAllocator) {
		super(type, host, port, netManager, packetAllocator);
	}

	@Override
	protected AbstractNettyInitializer newNettyInitializer() {
		return new AgentNettyInitializer(this.netManager,this.packetAllocator);
	}
	
}