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
public interface INetConnection {
	
	
	public void onAccepted();
	
	public void onDisconnected();
	
	public void send(IPacket packet);
	
	public void recv(IPacket packet);
	
}
