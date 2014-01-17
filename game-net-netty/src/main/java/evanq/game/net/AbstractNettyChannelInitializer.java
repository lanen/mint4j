package evanq.game.net;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public abstract class AbstractNettyChannelInitializer extends ChannelInitializer<SocketChannel> {


	/**
	 * 作为客户端，通过connectionType 来开启编解码器
	 * 
	 * @param connectionType
	 * @param ch
	 * @throws Exception
	 */
	public abstract void enableChannel(NetConnectionType connectionType,Channel ch) throws Exception;
	
}
