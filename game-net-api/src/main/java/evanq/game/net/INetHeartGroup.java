package evanq.game.net;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public interface INetHeartGroup {

	//心跳的频率
	public static final int HEART_BEAT_DELAY = 40000;
	
	public void add(INetHeart heart);
	
	public void remove(INetHeart heart);
	
	public void beat();
}
