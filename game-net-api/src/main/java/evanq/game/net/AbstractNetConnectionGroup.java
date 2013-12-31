package evanq.game.net;

import java.util.Iterator;

public abstract class AbstractNetConnectionGroup implements INetConnectionGroup {

	//TODO 最大连接数
	//TODO 连接工程
	private INetConnection[] connections;
	
	/**
	 * @param maxConnectionSize 最大连接数
	 * @param factory  连接对象工厂
	 */
	protected AbstractNetConnectionGroup(int maxConnectionSize,INetConnectionFactory factory,INetManager netManager) {
		
		if (maxConnectionSize < 1) {
			throw new IllegalArgumentException(String.format("maxConnectionSize: %d (expected: > 1)", maxConnectionSize));
		}
		
		if (null == factory) {
			throw new NullPointerException("factory");
		}
		
		if (null == netManager) {
			throw new NullPointerException("netManager");
		}
		
		connections = new AbstractNetConnection[maxConnectionSize];
	}
	
	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close(int typeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<INetConnection> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INetConnection connection(int typeId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void register(int typeId, INetConnection netConnection){
	
		//TODO 把连接注册进入连接组中
	}
}
