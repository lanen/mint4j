package evanq.game.net;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class NetHeartBeatTask implements Runnable {

	private INetHeartGroup group;
	
	public NetHeartBeatTask(INetHeartGroup group) {
		this.group = group;
	}
		
	@Override
	public void run() {
		if(null == group)return;
		group.beat();
	}

}
