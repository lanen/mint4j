package evanq.game.infrastructure.mint.commandexecutors.method;

import evanq.game.infrastructure.WorldUtils;
import evanq.game.infrastructure.mint.commandexecutors.AbstractCommandMapping;
import evanq.game.net.AbstractPacket;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class MethodCommandMapping extends AbstractCommandMapping<ExecutorMethodInfo> {

	//需要通过反射，将被Anno 标记的方法，转换成 CommandExecutorChain -> getExecutor = 
	

	@Override
	protected ExecutorMethod getExecutorInternal(Object command) {
		if(command instanceof AbstractPacket){
			AbstractPacket  p = (AbstractPacket)command;
			ExecutorMethodInfo valueOf = ExecutorMethodInfo.valueOf(p.getPacketId());
			return getExecutorMethod(valueOf);
		}
		return null;
	}

	@Override
	protected ExecutorMethodInfo getExecutorMethodInfo(ExecutorMethod exeMethod) {
		// TODO Auto-generated method stub
		return WorldUtils.commandExecutorResolver().getExecutorMethodInfo(exeMethod);
	}

	@Override
	protected boolean isExecutor(Class<?> beanType) {
		return true;
	}

}
