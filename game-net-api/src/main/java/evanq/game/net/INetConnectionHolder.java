package evanq.game.net;

import java.util.Iterator;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface INetConnectionHolder  {
	
	public INetConnection connection(int typeId);
	
	public void close();
	
	public void close(int typeId);
	
	public void close(INetConnection netConnection);	

	public void attach(INetConnection netConnection);	
	
	
}
