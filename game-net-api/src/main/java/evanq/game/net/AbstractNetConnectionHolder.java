package evanq.game.net;


/**
 * 持有连接的容器，可以是一个连接，也可以是一组连接。
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class AbstractNetConnectionHolder implements INetConnectionHolder {
	
	@Override
	public INetConnection connection(int typeId) {
		return null;
	}

	@Override
	public void close() {
		
	}

	@Override
	public void close(int typeId) {
		
	}

	@Override
	public void close(INetConnection netConnection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attach(INetConnection netConnection) {
		
	}

}
