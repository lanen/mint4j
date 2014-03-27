package evanq.game.demo.method.method;

import evanq.game.demo.method.CommandExecutorChain;
import evanq.game.demo.method.CommandMapping;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class MethodCommandMapping implements CommandMapping {

	//需要通过反射，将被Anno 标记的方法，转换成 CommandExecutorChain -> getExecutor = 
	
	@Override
	public CommandExecutorChain getExecutor(int opcode) throws Exception {
		return null;
	}

}
