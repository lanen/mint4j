package evanq.game.net.sapi;

/**
 * 
 * 网络设备接口
 * 
 * @author Evan
 *
 */
public interface INetInterface {

	/**
	 * 
	 * 打开接口
	 * 
	 * @return
	 */
	public int open();
	
	
	/**
	 * 
	 * 关闭接口
	 * 
	 * @return
	 */
	public int close()	;
	
	
	/**
	 * 
	 * 接口工作
	 * 
	 * @return
	 */
	public int work();
	
	
}
