package evanq.game.net;

/**
 * 职责：<br />
 * 
 * 维持连接状态，将命令转发命令监听器
 * 
 * 连接的状态，决定连接执行的命令
 * @author Evan
 *
 */
public interface INetConnection  {	
	
	NetConnectionType type();
	
	NetConnectionType type(NetConnectionType newtype);
	
	INetConnectionFSM fsm();
	
	INetConnectionFSM fsm(INetConnectionFSM fsm);
	
	public void initConnection();
	
	public void send(IPacket packet);
	
	public void recv(IPacket packet);
	
}
