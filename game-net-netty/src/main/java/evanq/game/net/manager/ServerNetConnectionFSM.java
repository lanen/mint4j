package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionFSM;
import evanq.game.net.INetConnectionState;
import evanq.game.net.INetHeart;
import evanq.game.net.NetConnectionEvent;
import evanq.game.net.NetConnectionType;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;

/**
 * 服务器端连接管理状态机
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ServerNetConnectionFSM implements INetConnectionFSM {
	
	private static Trace logger = LogSystem.getDefaultTrace(ServerNetConnectionFSM.class);

	//当前连接
	private INetConnection connection;
	
	//当前连接状态
	private INetConnectionState currentState;
	
	//保持连接管理器	
	private AbstractNetConnectionManager connectionManager;
	
	private ServerNetHeart heart;


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
		if(NetConnectionEvent.PING == event){
			
			if(null!=heart){
				
				heart.updateClientBeat();
			}
			return;
		}
		this.currentState.update(connection,event);
	}
	
	private void initHeart(){
		
		if(connection.type() == NetConnectionType.CLIENT_MASTER){
			this.heart = new ServerNetHeart(this);
	
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
	class ServerCreatingState implements INetConnectionState{
		
		@Override
		public void update(INetConnection connection, NetConnectionEvent event) {
			switch(event){
			
			case CREATE_OK:
				System.out.println("服务端收到一个连接");
				
				//连接创建完毕，放入等待验证的容器中
				
				break;
			case AUTH_OK:
				
				if(null == connection.type()){
					logger.warn("验证完毕的的连接，没有赋予类型");
					//TODO 做拒绝访问控制
				}
				//注册连接到心跳机制中
				initHeart();
				
				logger.info("客户端连接验证完毕。进入工作状态" + connection.type());
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
