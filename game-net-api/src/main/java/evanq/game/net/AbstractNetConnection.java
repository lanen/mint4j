package evanq.game.net;

import java.util.Iterator;

public abstract class AbstractNetConnection implements INetConnection {

	
	
	@Override
	public NetConnectionType type() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public INetConnectionGroup group() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onConnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send(IPacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recv(IPacket packet) {
		// TODO Auto-generated method stub
		
	}

	
}
