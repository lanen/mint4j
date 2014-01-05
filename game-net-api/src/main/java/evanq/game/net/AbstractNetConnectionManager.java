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
		AbstractNetConnectionFSM fsm = new AbstractNetConnectionFSM(connection);
		fsm.update(new CreatingState());
		fsm.fireEvent(NetConnectionEvent.CREATE_OK);
	}

	@Override
	public void close(INetConnection connection) {
		
		connection.fsm().fireEvent(NetConnectionEvent.CLOSE);
		
	}

	public SingleThreadHolder singleThread(){
		return holder;
	}
	
	static class SingleThreadHolder extends AbstractTask {
		
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
	
	
	class CreatingState implements INetConnectionState{
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			switch(event){
			case CREATE_OK:
				//连接创建完毕，放入等待验证的容器中
				//UnAuthGroupHolder.attach(connection);
				
				break;
			case CREATE_FAILED:
				//UnAuthGroupHolder.unAttach(connection);
				connection.fsm().update(new CloseState());
				break;
			case AUTH_OK:			
				//TODO step 2. 进入账号载入流程
				connection.fsm().update(new OpenState());				
				break;
			case AUTH_FAILED:
				connection.fsm().update(new CloseState());
				break;
			default:
				break;
			}
			
		}
		
	}
	
	class OpenState implements INetConnectionState{
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			// TODO Auto-generated method stub
			System.out.println("enter open state");
		}
		
	}
	
	class BrokenState implements INetConnectionState{
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	//连接挂起状态
	class HangState implements INetConnectionState{

		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class DelayCloseState implements INetConnectionState{

		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			
		}
		
	}
	class CloseState implements INetConnectionState {

		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			// TODO 
			
		}
		
	}
		
}
