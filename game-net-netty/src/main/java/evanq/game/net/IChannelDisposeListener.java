package evanq.game.net;

import io.netty.channel.Channel;

interface IChannelDisposeListener {

	public void onDispose(Channel channel);	
	
}
