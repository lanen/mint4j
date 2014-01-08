package evanq.game.net;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface INetServiceListener {

	public void willStartNetService(INetService netService);
	
	public void didStartNetService(INetService netService);
	
	public void willCloseNetService(INetService netService);
	
	public void didCloseNetService(INetService netService);
	
}
