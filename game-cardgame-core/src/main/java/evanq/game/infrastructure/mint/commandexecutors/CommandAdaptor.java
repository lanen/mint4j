package evanq.game.infrastructure.mint.commandexecutors;

/**
 * 
 * 作为数据包与数据命令执行器的桥接
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface CommandAdaptor {

	/**
	 * 
	 * @param executor
	 * @return
	 */
	public boolean supports(Object executor);
	
	/**
	 * 
	 * @param command
	 * @param executor
	 */
	public void execute(Object command, Object executor);
	
}
