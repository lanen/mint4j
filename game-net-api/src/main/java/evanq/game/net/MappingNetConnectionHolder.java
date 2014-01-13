package evanq.game.net;

import java.util.Map;

import evanq.game.helper.New;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class MappingNetConnectionHolder extends AbstractNetConnectionHolder {

	protected Map<Integer,INetConnection> connections = New.hashMap();
	
	@Override
	public INetConnection connection(int typeId) {
		return connections.get(typeId);
	}
	
	//TODO 子类覆盖，提供连接的表示
	protected int key(INetConnection netConnection){
		//10000保证同种类型的类型有10000个存在
		int key = 10000 * netConnection.type().value();
		return key;
	}
	
	@Override
	public void add(INetConnection netConnection) {
		int key = key(netConnection);
		connections.put(key, netConnection);
	}

	@Override
	public void remove(INetConnection netConnection) {
		int key = key(netConnection);
		connections.remove(key);
	}

	@Override
	public void removeAll() {
		connections.clear();
	}


}
