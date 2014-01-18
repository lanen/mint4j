package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionState;
import evanq.game.net.NetConnectionEvent;
import evanq.game.net.NetConnectionState;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;

/**
 * 
 * 服务器端连接管理状态机
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ServerNetConnectionFSM extends AbstractNetConnectionFSM {
	
	private static Trace logger = LogSystem.getDefaultTrace(ServerNetConnectionFSM.class);

	public ServerNetConnectionFSM(AbstractNetConnectionManager connectionManager,INetConnection connection) {
		super(connectionManager,connection);
		
		update(new ServerCreatingState());		
	}
	
	@Override
	public void beat() {
		fireEvent(NetConnectionEvent.PING_CHECK);
	}

	/**
	 * 客户端建立连接
	 * 
	 * @author Evan cppmain@gmail.com
	 *
	 */
	class ServerCreatingState implements INetConnectionState {
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			
			
			switch(event){
			
			case CREATE_OK:
				
				break;
			case AUTH_OK:
				//注册连接到心跳机制中
				initHeart();
				//TODO 使用future 模式与其他模块通讯
				connectionManager.addConnection(connection);				
				ServerNetConnectionFSM.this.update(new ServerConnectionOpenState());

				break;
			case AUTH_FAILED:
				
				break;
			default:				
				
				break;
			}
		}

		@Override
		public NetConnectionState state() {
			return NetConnectionState.CONNECTING;
		}
		
	}
	
	
	/**
	 * 
	 * @author Evan cppmain@gmail.com
	 *
	 */
	class ServerConnectionOpenState implements INetConnectionState {

		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			switch (event) {
			case PING:
				if(null != heart){				
					heart.hearBeat();
				}
				break;
			case PING_CHECK:
				if(null!=heart && heart.isDead()){	
					ServerNetConnectionFSM.this.update(new ServerConnectionBrokenState());
				}
				break;
			case DELAYED_CLOSE:	
				
				ServerNetConnectionFSM.this.update(new ServerConnectionBrokenState());

				break;
			case CLOSE:
				
				ServerNetConnectionFSM.this.update(new ServerConnectionClosingState());
				break;
			default:
				break;
			}
			
		}
		@Override
		public NetConnectionState state() {
			return NetConnectionState.OPEN;
		}
	}
	
	class ServerConnectionBrokenState implements INetConnectionState {
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			
		}
		
		@Override
		public NetConnectionState state() {
			return NetConnectionState.BROKEN;
		}
	}
	
	class ServerConnectionClosingState implements INetConnectionState{

		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			destoryHeart();
			//TODO 使用future 模式与其他模块通讯
			connectionManager.removeConnection(connection);
		}
		
		@Override
		public NetConnectionState state() {
			return NetConnectionState.CLOSED;
		}
	}
	
	
}
