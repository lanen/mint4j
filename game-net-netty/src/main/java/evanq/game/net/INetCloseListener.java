package evanq.game.net;

import io.netty.channel.Channel;

public interface INetCloseListener {

	public void onClose(Channel channel);
	
	
}
