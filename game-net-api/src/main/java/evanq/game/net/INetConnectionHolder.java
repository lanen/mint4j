package evanq.game.net;

import java.util.Iterator;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface INetConnectionHolder extends Iterable<INetConnection> {
	
	public INetConnection connection(int typeId);
	
	public void close();
	
	public void close(int typeId);
	
	public void close(INetConnection netConnection);
	
	public void unAttach(int typeId);
	
	public void unAttach(INetConnection netConnection);
	
	public void attach(INetConnection netConnection);
	
	public Iterator<INetConnection> iterator();	
}
