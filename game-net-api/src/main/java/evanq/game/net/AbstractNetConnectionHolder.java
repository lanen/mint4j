package evanq.game.net;

import java.util.Iterator;
import java.util.Queue;

import evanq.game.helper.New;

/**
 * 持有连接的容器，可以是一个连接，也可以是一组连接。
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class AbstractNetConnectionHolder implements INetConnectionHolder{

	private Queue<INetConnection> queue;
	
	public AbstractNetConnectionHolder() {		
		queue = newQueue();
	}
	
	protected Queue<INetConnection> newQueue(){
		return New.newLinkedQueue();
	}
	
	@Override
	public INetConnection connection(int typeId) {
		return null;
	}

	@Override
	public void close() {
		
	}

	@Override
	public void close(int typeId) {
		
	}

	@Override
	public void close(INetConnection netConnection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unAttach(int typeId) {
		
	}

	@Override
	public void unAttach(INetConnection netConnection) {
		queue.remove(netConnection);
	}

	@Override
	public void attach(INetConnection netConnection) {
		queue.add(netConnection);
	}

	@Override
	public Iterator<INetConnection> iterator() {
		return queue.iterator();
	}

}
