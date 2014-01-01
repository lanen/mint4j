package evanq.game.net;

/**
 * 网络连接管理器
 * 
 * @see INetConnectionHolder
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class AbstractNetConnectionManager implements INetConnectionManager {

	private static class Singleton {
		public static AbstractNetConnectionManager INSTANCE = new AbstractNetConnectionManager();
	}

	public static AbstractNetConnectionManager getInstance() {
		return Singleton.INSTANCE;
	}
	/**
	 * 未带验证的连接
	 */
	private INetConnectionHolder UnAuthGroupHolder;
	private AbstractNetConnectionManager() {
		if(null == UnAuthGroupHolder){
			UnAuthGroupHolder = null;
		}
	}
	
	/**
	 * 建立一个验证容器
	 * @return
	 */
	protected INetConnectionHolder newUnAuthGroupHolder(){
		return null;
	}
	
	
	@Override
	public void accpet(INetConnection connection) {
		//TODO 新建连接
		
		//TODO 交给管理组
		
		//TODO 连接进行验证
		
		//TODO 验证完毕，将连接交给holder

	}

	@Override
	public void close(INetConnectionHolder holder) {
		// TODO Auto-generated method stub		
		for (INetConnection iNetConnection : holder) {
			
		}
	}

	@Override
	public void heat() {
		// TODO Auto-generated method stub

	}

}
