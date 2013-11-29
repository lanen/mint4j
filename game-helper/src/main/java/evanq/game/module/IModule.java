package evanq.game.module;

/**
 * 模块，物理意义的隔离。
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface IModule {

	/**
	 * 模块的准备状态
	 * 
	 * @return
	 */
	public int prepareState();
	
	/**
	 * 加载模块
	 */
	public void load();
	
	/**
	 * 卸载模块
	 */
	public void offLoad();
	
}
