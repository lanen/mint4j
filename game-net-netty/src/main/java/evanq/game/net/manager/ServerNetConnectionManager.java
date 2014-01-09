package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.NetServiceType;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class ServerNetConnectionManager extends AbstractNetConnectionManager {

	public ServerNetConnectionManager() {
		super(NetServiceType.SERVER);
	}
	
	@Override
	public void accpet(INetConnection connection) {

	}

	@Override
	public void close(INetConnection connection) {

	}

}
