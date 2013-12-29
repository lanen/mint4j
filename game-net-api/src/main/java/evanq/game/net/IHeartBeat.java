package evanq.game.net;

/**
 * 
 * 心跳
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface IHeartBeat {

	public void beforeBeat();
	public void beat();	
	public void afterBeat();
	
}
