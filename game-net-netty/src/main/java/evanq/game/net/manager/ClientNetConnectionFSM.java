package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.AbstractNettyChannelInitializer;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionState;
import evanq.game.net.NetConnectionEvent;
import evanq.game.net.NetConnectionState;
import evanq.game.net.NetConnectionType;
import evanq.game.net.PacketConst;
import evanq.game.net.packets.CHeartBeat;
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
public class ClientNetConnectionFSM extends AbstractNetConnectionFSM {
	
	private static Trace logger = LogSystem.getDefaultTrace(ClientNetConnectionFSM.class);
	
	public ClientNetConnectionFSM(AbstractNetConnectionManager connectionManager, INetConnection connection) {
		
		super(connectionManager,connection);
				
		update(new ClientCreatingState());
		
	}
	
	
	@Override
	public void beat() {
		if(null == heart)return;
		
		CHeartBeat beatPacket = new CHeartBeat();
		beatPacket.setPacketId(PacketConst.C_HEART_BEAT);
		connection.send(beatPacket);
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
			
				NetConnectionType channelType = AbstractNettyChannelInitializer.getChannelType(connection);

				//step 1. 客户端与服务端建立了连接				
				CRequestConnection requestConnection = new CRequestConnection();
				requestConnection.setPacketId(PacketConst.C_CONNECT_REQUEST);
				requestConnection.setAccessToken(999);
				requestConnection.setConnectionType(channelType.value());
				connection.send(requestConnection);
				
				//step 2. 在建立状态进行验证交互

				break;
			case AUTH_OK:
				//TODO 经过验证之后，才分配特定的编解码器
				initHeart();
				connection.fsm().update(new ClientOpenState());
				connectionManager.addConnection(connection);
				
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
	
	class ClientOpenState implements INetConnectionState{
		
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
					ClientNetConnectionFSM.this.update(new ClientDelayCloseState());
				}
				break;
			case DELAYED_CLOSE:	
				
				break;
			case CLOSE:
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
	
	
	class ClientDelayCloseState implements INetConnectionState{

		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			
			
			
			
		}

		@Override
		public NetConnectionState state() {
			return NetConnectionState.BROKEN;
		}
	}
	
	class ClientCloseState implements INetConnectionState {

		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			destoryHeart();
			connectionManager.removeConnection(connection);
		}

		@Override
		public NetConnectionState state() {
			return NetConnectionState.CLOSED;
		}
	}

}
