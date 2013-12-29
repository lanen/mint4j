package evanq.game.net;

import io.netty.channel.Channel;

class NettyDisconnection implements INetConnection {

	private Channel channel;
	
	public NettyDisconnection(Channel channel) {

		this.channel = channel;
	}
	
	@Override
	public void onAccepted() {
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

}
