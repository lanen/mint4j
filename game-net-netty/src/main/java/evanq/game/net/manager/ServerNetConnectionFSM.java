package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionFSM;
import evanq.game.net.INetConnectionState;
import evanq.game.net.NetConnectionEvent;
import evanq.game.net.PacketConst;
import evanq.game.net.manager.ClientNetConnectionFSM.ClientCreatingState;
import evanq.game.net.manager.ClientNetConnectionFSM.ClientOpenState;
import evanq.game.net.packets.CRequestConnection;

/**
 * 服务器端连接管理状态机
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ServerNetConnectionFSM implements INetConnectionFSM {

	//当前连接
	private INetConnection connection;
	
	//当前连接状态
	private INetConnectionState currentState;
	
	//保持连接管理器	
	private AbstractNetConnectionManager connectionManager;

	public ServerNetConnectionFSM(AbstractNetConnectionManager connectionManager,INetConnection connection) {
		
		this.connectionManager = connectionManager;
		
		this.connection = connection;
		this.connection.fsm(this);
		
		update(new ServerCreatingState());
		
	}
	
	@Override
	public void update(INetConnectionState state) {
		this.currentState = state;
	}

	@Override
	public void fireEvent(NetConnectionEvent event) {
		this.currentState.update(connection,event);
	}
	
	
	/**
	 * 客户端建立连接
	 * 
	 * @author Evan cppmain@gmail.com
	 *
	 */
	class ServerCreatingState implements INetConnectionState{
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			switch(event){
			
			case CREATE_OK:
				System.out.println("服务端收到一个连接");
		
				break;
			case AUTH_OK:
				System.out.println("客户端连接验证完毕。进入工作状态");
				//connection.fsm().update(new ClientOpenState());
				break;
			case AUTH_FAILED:
				
				break;
			default:
				
				
				break;
			}			
		}
		
	}
	

}
