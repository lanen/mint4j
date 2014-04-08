package evanq.game.infrastructure.mint.commandexecutors.method;

import evanq.game.infrastructure.mint.commandexecutors.AbstractCommandMapping;
import evanq.game.infrastructure.mint.commandexecutors.CommandExecutorChain;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class MethodCommandMapping extends AbstractCommandMapping<ExecutorMethodInfo> {

	//需要通过反射，将被Anno 标记的方法，转换成 CommandExecutorChain -> getExecutor = 
	

	@Override
	protected Object getExecutorInternal(int opcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isExecutor(Class<?> beanType) {
		return false;
	}

	
}
