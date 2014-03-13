package evanq.game.net;

/**
 * 
 * 数据包
 * 
 * @author Evan
 *
 */
public interface IPacket extends INetCommand{

	/**
	 * 
	 * Return the connection of this command.
	 * 
	 * @return {@link INetConnection}
	 */
	INetConnection connection();
	
	/**
	 * 设置当前的连接
	 * @param nc
	 * @return
	 */
	INetConnection connection(INetConnection nc);
	

}
