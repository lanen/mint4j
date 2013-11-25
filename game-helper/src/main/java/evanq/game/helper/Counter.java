package evanq.game.helper;

/**
 * 计数器
 * 游戏中会出现大量的计数器，累计等功能
 * @author Evan
 *
 * @param <E>
 * @param <B>
 */
public interface Counter<NUMBER> extends Cloneable  {

	/**
	 * 
	 * @param num
	 * @return
	 */
	public NUMBER add(NUMBER num);
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public NUMBER reduce(NUMBER num);

	
	/**
	 * 返回当前数值
	 * @return
	 */
	public NUMBER get();
	
	
	/**
	 * 重置
	 * @return
	 */
	public boolean reset();
}
