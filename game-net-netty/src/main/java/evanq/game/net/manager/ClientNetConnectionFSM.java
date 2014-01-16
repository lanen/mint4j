package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionFSM;
import evanq.game.net.INetConnectionState;
import evanq.game.net.INetHeart;
import evanq.game.net.NetConnectionEvent;
import evanq.game.net.NetConnectionType;
import evanq.game.net.PacketConst;
import evanq.game.net.packets.CRequestConnection;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;

/**
 * 连接状态机应该与连接状态一一相对
 * 
 * 一个账号，可以建立多个连接，到服务器。客户端保持多个连接，也对应多个状态机
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ClientNetConnectionFSM implements INetConnectionFSM {
	
	private static Trace logger = LogSystem.getDefaultTrace(ClientNetConnectionFSM.class);

	//持有当前状态机的连接
	private INetConnection connection;
	
	//连接状态
	private INetConnectionState currentState;
	
	//保持连接管理器	
	private AbstractNetConnectionManager connectionManager;
	
	//连接的心跳
	private INetHeart heart;
	
	public ClientNetConnectionFSM(AbstractNetConnectionManager connectionManager, INetConnection connection) {
		
		this.connectionManager = connectionManager;
		
		this.connection = connection;
		this.connection.fsm(this);
				
		update(new ClientCreatingState());
		
	}
	
	@Override
	public void update(INetConnectionState state) {
		this.currentState = state;
	}

	@Override
	public void fireEvent(NetConnectionEvent event) {		
		this.currentState.update(connection,event);
	}
	
	private void initHeart(){
		
		if(connection.type() == NetConnectionType.CLIENT_MASTER){
			this.heart = new ClientNetHeart(this.connection);
			connectionManager.registerHeart(heart);
		}
		
	}
	
	private void destoryHeart(){
		if(null != heart){
			connectionManager.deRegisterHeart(heart);
		}
	}
	
	/**
	 * 客户端建立连接
	 * 
	 * @author Evan cppmain@gmail.com
	 *
	 */
	class ClientCreatingState implements INetConnectionState{
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			switch(event){
			
			case CREATE_OK:
				logger.info("客户端建立连接");
				
				initHeart();

				
				logger.info("上传送验证信息");
				//step 1. 客户端与服务端建立了连接
				CRequestConnection requestConnection = new CRequestConnection();
				requestConnection.setPacketId(PacketConst.C_CONNECT_REQUEST);
				requestConnection.setAccessToken(999);
				requestConnection.setConnectionType(connection.type().value());
				System.out.println(requestConnection);
				connection.send(requestConnection);
				//step 2. 在建立状态进行验证交互

				connection.initConnection();
				break;
			case AUTH_OK:
				logger.info("客户端连接验证完毕。进入工作状态");
				connection.fsm().update(new ClientOpenState());
				break;
			case AUTH_FAILED:
				logger.info("客户端连接验证完毕。失败，进入重新验证状态");
				
				break;
			default:
				
				
				break;
			}			
		}
		
	}
	
	class ClientOpenState implements INetConnectionState{
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class ClientBrokenState implements INetConnectionState{
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	class ClientDelayCloseState implements INetConnectionState{

		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			destoryHeart();
		}
		
	}
	
	class ClientCloseState implements INetConnectionState {

		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			// TODO 
		
		}
		
	}
	
}
