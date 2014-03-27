package evanq.game.demo.method;

/**
 * 
 * 命令处理器类型映射
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface CommandMapping {

	/**
	 * 
	 * @param opcode
	 * @return
	 * @throws Exception
	 */
	CommandExecutorChain getExecutor(int opcode) throws Exception;
	
}
