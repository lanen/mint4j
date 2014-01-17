package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionState;
import evanq.game.net.NetConnectionEvent;
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
				System.out.println("服务端收到一个连接");
				
				break;
			case AUTH_OK:
				
				if(null == connection.type()){
					logger.warn("验证完毕的的连接，没有赋予类型");
					//TODO 做拒绝访问控制
				}
				//注册连接到心跳机制中
				initHeart();
				
				logger.info("客户端连接验证完毕。进入工作状态" + connection.type());
				ServerNetConnectionFSM.this.update(new ServerConnectionOpenState());

				break;
			case AUTH_FAILED:
				
				break;
			default:				
				
				break;
			}			
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
				System.out.println("DELAYED_CLOSE");
				ServerNetConnectionFSM.this.update(new ServerConnectionBrokenState());

				break;
			case CLOSE:
				System.out.println("CLOSE");
				ServerNetConnectionFSM.this.update(new ServerConnectionClosingState());
				break;
			default:
				break;
			}
			
		}
		
	}
	
	class ServerConnectionBrokenState implements INetConnectionState{
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			
		}
		
	}
	
	class ServerConnectionClosingState implements INetConnectionState{

		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			
		}
		
	}
	
	
}
