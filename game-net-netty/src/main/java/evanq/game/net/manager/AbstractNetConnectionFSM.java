package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionFSM;
import evanq.game.net.INetConnectionState;
import evanq.game.net.NetConnectionEvent;

/**
 * 
 * 抽象连接状态机
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractNetConnectionFSM implements INetConnectionFSM {
	
	//当前连接
	protected INetConnection connection;
	
	//当前连接状态
	protected INetConnectionState currentState;
	
	//保持连接管理器	
	protected AbstractNetConnectionManager connectionManager;
	
	//连接的心跳
	protected AbstractNetHeart heart;
	
	protected AbstractNetConnectionFSM(AbstractNetConnectionManager connectionManager,INetConnection connection) {
		
		this.connectionManager = connectionManager;
		
		this.connection = connection;
		this.connection.fsm(this);
		
	}
	
	@Override
	public void update(INetConnectionState state) {
		this.currentState = state;
	}

	@Override
	public void fireEvent(NetConnectionEvent event) {
		this.currentState.update(connection,event);
	}
	
	public abstract void beat();
	
	protected void initHeart(){
		AbstractNetHeart newNetHeart = newNetHeart();
		if(null != newNetHeart){
			this.heart = newNetHeart;
			connectionManager.registerHeart(heart);
		}
	}
	
	protected AbstractNetHeart newNetHeart(){
		return new NetHeart(this);
	}
	
	
	protected void destoryHeart(){
		if(null != heart){
			connectionManager.deRegisterHeart(heart);
		}
	}
	
	public String toString(){
		
		StringBuffer buf = new StringBuffer();
		buf.append("Connection:").append(connection);
		buf.append(",State:").append(currentState);
		return buf.toString();
	}
}
