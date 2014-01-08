package evanq.game.net;

/**
 * 
 * 管理连接的状态机
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class AbstractNetConnectionFSM implements INetConnectionFSM {

	private INetConnection connection;
	
	private INetConnectionState currentState;
	
	private AbstractNetConnectionManager connectionManager;
	
	public AbstractNetConnectionFSM(AbstractNetConnectionManager connectionManager,INetConnection connection) {
	
		this.connectionManager = connectionManager;
		
		this.connection = connection;
		this.connection.fsm(this);
		
		update(new CreatingState());
	}
	
	@Override
	public void update(INetConnectionState state) {
		this.currentState = state;
	}

	@Override
	public void fireEvent(NetConnectionEvent event) {
		this.currentState.update(connection,event);
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
