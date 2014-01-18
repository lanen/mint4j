package evanq.game.net;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class DefaultNetServiceHandler implements INetServiceHandler {

	private INetConnectionManager netManager;
	
	private AbstractPacketAllocator packetAllocator;
	
	public DefaultNetServiceHandler(INetConnectionManager netManager,AbstractPacketAllocator packetAllocator) {
		
		if(null == netManager){
			throw new NullPointerException("netManager");
		}
		if(null == packetAllocator){
			throw new NullPointerException("packetAllocator");
		}
		
		this.netManager = netManager;
		this.packetAllocator = packetAllocator;
	}
	
	@Override
	public AbstractPacketAllocator packetAllocator() {
		return packetAllocator;
	}

	@Override
	public INetConnectionManager netConnectionManager() {
		return netManager;
	}

	@Override
	public void fireWillStartNetService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fireDidStartNetService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fireWillCloseNetService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fireDidCloseNetService() {
		// TODO Auto-generated method stub
		
	}
	
}
