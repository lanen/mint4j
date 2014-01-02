package evanq.game.net;

import java.util.Iterator;

import io.netty.channel.Channel;

class NettyDisconnection implements INetConnection {

	private Channel channel;
	
	public NettyDisconnection(Channel channel) {

		this.channel = channel;
	}
	
	@Override
	public void onConnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnected() {
		
		System.out.println("NettyDisconnection.onDisconnected() - "+channel);
	}

	@Override
	public void send(IPacket packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recv(IPacket packet) {
		// TODO Auto-generated method stub
		
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

}
