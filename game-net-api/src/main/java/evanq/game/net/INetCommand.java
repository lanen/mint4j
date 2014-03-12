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
public interface INetCommand<PACKET> {

	/**
	 * 内部收到数据
	 */
	void execute();
	
	/**
	 * 供net-api之外扩展
	 * @param P
	 */
	public void execute(PACKET P);
}
