package evanq.game.net;

import java.util.List;

import evanq.game.helper.New;

/**
 * 这个类的实现有待研究 
 *
 * @author Evan cppmain@gmail.com
 *
 */
public class CollectionNetConnectionHolder extends AbstractNetConnectionHolder {

	protected List<INetConnection> connections = New.arrayList();
	
	@Override
	protected int key(INetConnection netConnection) {
		
		return 0;
	}

	@Override
	public INetConnection connection(int typeId) {
		
		return null;
	}

	@Override
	public void add(INetConnection netConnection) {

	}

	@Override
	public void remove(INetConnection netConnection) {

	}

	@Override
	public void removeAll() {

	}

	@Override
	public void send(AbstractPacket packet) {
		
	}

}
