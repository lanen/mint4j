package evanq.game.net;

import java.nio.channels.SocketChannel;

public interface INetConnectionFactory {

	public INetConnection newConnection(SocketChannel socketChannel);
	
}
