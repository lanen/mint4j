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
	 * 设置当前的连接
	 * @param nc
	 * @return
	 */
	INetConnection connection(INetConnection nc);
	
	/**
	 * 
	 */
	public void execute();
	
}
