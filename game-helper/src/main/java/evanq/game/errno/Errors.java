package evanq.game.errno;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class Errors {

	/**
	 * 冒出错误
	 * 
	 * @param errno
	 * @return
	 */
	public static ErrorNumber raise(int errno){
		return null;
	}
	
	/**
	 * 收集错误
	 * @param error
	 */
	public static void collect(int error){
		
	}
}

