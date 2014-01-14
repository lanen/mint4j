package evanq.game.net.manager;

import evanq.game.net.INetConnectionFSM;
import evanq.game.net.INetHeart;
import evanq.game.net.NetConnectionEvent;

/**
 * 
 * 服务端的心跳
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ServerNetHeart implements INetHeart {

	private long lastBeatTimeMS;
	
	private INetConnectionFSM fsm;
	
	public ServerNetHeart(INetConnectionFSM fsm) {
		this.fsm = fsm;
	}
	
	@Override
	public void beat() {
		if(isDead()){
			fsm.fireEvent(NetConnectionEvent.CLOSE);
		}
	}

	public void updateClientBeat(){
		lastBeatTimeMS = System.currentTimeMillis();
	}
	@Override
	public boolean isDead() {
		return lastBeatTimeMS < System.currentTimeMillis() + 45000;
	}

}
