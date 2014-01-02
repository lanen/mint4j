package evanq.game.net;

import io.netty.channel.Channel;

class NettyNetConnectionManagerAdaptor implements INetConnectionManager {

	private INetConnectionManager INetConnectionManager;
	
	NettyNetConnectionManagerAdaptor(INetConnectionManager the){
		INetConnectionManager = the;
	}
	
	public INetConnection get(Channel channel){
		return null;
	}
	
	public void accpet(Channel channel){
		
	}
	
	@Override
	public void accpet(INetConnection connection) {
		INetConnectionManager.accpet(connection);
	}
	
	public void close(Channel channel){
	
		INetConnection iNetConnection = get(channel);
		if (null != iNetConnection) {
			
		}
	}
	
	
	@Override
	public void close(INetConnectionHolder holder) {
		INetConnectionManager.close(holder);

	}

	@Override
	public void heat() {
		// TODO Auto-generated method stub

	}

}
