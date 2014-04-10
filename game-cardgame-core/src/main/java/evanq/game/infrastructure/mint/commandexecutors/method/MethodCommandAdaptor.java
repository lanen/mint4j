package evanq.game.infrastructure.mint.commandexecutors.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import evanq.game.infrastructure.mint.commandexecutors.AbstractCommandAdaptor;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class MethodCommandAdaptor extends AbstractCommandAdaptor {


	@Override
	protected boolean supportsInternal(ExecutorMethod executorMethod) {
		return true;
	}

	protected void executeInternal(Object command, ExecutorMethod executorMethod){
	
		Method method = executorMethod.getMethod();
		Object instance = executorMethod.getExecutor();
		
		try {
			method.invoke(instance,new Object[]{ command });
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}
