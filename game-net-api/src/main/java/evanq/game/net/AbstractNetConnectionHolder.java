package evanq.game.net;



/**
 * 
 * 持有连接的容器，可以是一个连接，也可以是一组连接。
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractNetConnectionHolder implements INetConnectionHolder {
	
	//TODO 子类覆盖，提供连接的表示
	protected abstract int key(INetConnection netConnection);
	
	public abstract void send(AbstractPacket packet);
}
