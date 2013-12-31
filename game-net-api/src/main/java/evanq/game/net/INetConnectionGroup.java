package evanq.game.net;

import java.util.Iterator;

public interface INetConnectionGroup extends Iterable<INetConnection> {
	
	public boolean isClosed();
	
	public void close();
	
	public void close(int typeId);
	
	public Iterator<INetConnection> iterator();	
	
	public INetConnection connection(int typeId);
	
}
