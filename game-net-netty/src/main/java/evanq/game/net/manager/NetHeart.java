package evanq.game.net.manager;

/**
 * 
 * 服务端的心跳
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class NetHeart extends AbstractNetHeart {
	
	public NetHeart(AbstractNetConnectionFSM fsm) {
		super(fsm);
	}
	
	@Override
	public void beat() {
		//服务端嗅探心跳时间
		fsm.beat();
	}

	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append(fsm);
		return buf.toString()	;
	}
}
