package evanq.game.net;

/**
 * 
 * 数据包- 命令模式
 * 
 * 命令要知道是来自哪个连接
 * 
 * @author Evan
 *
 */
public interface INetCommand {

	/**
	 * 
	 * Return the connection of this command.
	 * 
	 * @return {@link INetConnection}
	 */
	INetConnection connection();
	
	/**
	 * 
	 */
	public void execute();
	
}
