package evanq.game.net.manager;

import evanq.game.net.INetHeart;
import evanq.game.net.INetHeartGroup;

/**
 * 心跳状态记录
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractNetHeart implements INetHeart {
	
	/**
	 * 最近一次心跳时间
	 */
	protected long lastBeatTimeMS;
	
	protected AbstractNetConnectionFSM fsm;
	
	public AbstractNetHeart(AbstractNetConnectionFSM fsm) {
		this.fsm = fsm;
		lastBeatTimeMS=System.currentTimeMillis();
	}
		
	public void hearBeat(){
		lastBeatTimeMS = System.currentTimeMillis();
	}
	
	@Override
	public boolean isDead() {
		
		return lastBeatTimeMS + INetHeartGroup.HEART_BEAT_DELAY + INetHeartGroup.HEART_BEAT_DELAY< System.currentTimeMillis() ;
	}

}
