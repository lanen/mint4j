package evanq.game.net;

import java.util.Map;

import evanq.game.concurrent.loop.AbstractTask;
import evanq.game.concurrent.loop.DefaultLoopGroup;
import evanq.game.concurrent.loop.ICommand;
import evanq.game.helper.New;

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
	
	private SingleThreadHolder holder;
	
	/**
	 * 未带验证的连接
	 */
	private INetConnectionHolder UnAuthGroupHolder;
	
	private Map<INetConnection,INetConnectionHolder> connections = New.newConcurrentHashMap();
	
	
	private AbstractNetConnectionManager() {
		if(null == UnAuthGroupHolder){
			UnAuthGroupHolder = new AbstractNetConnectionHolder();
		}
		
		holder = new SingleThreadHolder();
		
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
		
		UnAuthGroupHolder.attach(connection);
		connections.put(connection, UnAuthGroupHolder);
		//TODO 新建连接
		
		//TODO 交给管理组
		
		//TODO 连接进行验证
		
		//TODO 验证完毕，将连接交给holder

	}

	@Override
	public void close(INetConnection connection) {
		// TODO Auto-generated method stub		
	}

	public SingleThreadHolder singleThread(){
		return holder;
	}
	
	static class SingleThreadHolder extends AbstractTask{
		
		private DefaultLoopGroup group = new DefaultLoopGroup(1);
		
		public SingleThreadHolder() {
			super(null);	
			group.register(this);
		}
		
		
		@Override
		protected void doRegister() {
			
		}

		@Override
		protected void doAccept(ICommand command) {
			try{
				command.execute();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
		
}
