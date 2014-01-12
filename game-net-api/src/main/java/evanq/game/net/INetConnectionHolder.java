package evanq.game.net;


/**
 * 
 * to hold connection.
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface INetConnectionHolder  {
	
	public INetConnection connection(int typeId);
	
	public void add(INetConnection netConnection);
	
	public void remove(INetConnection netConnection);

	public void removeAll();
}
