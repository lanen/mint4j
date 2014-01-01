package evanq.game.net;

import io.netty.channel.Channel;

class NettyDisconnection extends AbstractNetConnection {

	private Channel channel;
	
	public NettyDisconnection(Channel channel) {

		this.channel = channel;
	}

	@Override
	public NetConnectionType type() {
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
