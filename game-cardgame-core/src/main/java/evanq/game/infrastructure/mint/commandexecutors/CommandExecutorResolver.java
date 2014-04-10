package evanq.game.infrastructure.mint.commandexecutors;

import java.util.Set;

import evanq.game.infrastructure.mint.commandexecutors.method.ExecutorMethod;
import evanq.game.infrastructure.mint.commandexecutors.method.ExecutorMethodInfo;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface CommandExecutorResolver {

	/**
	 * 从指定的包下面查找 ExecutorMethod
	 * @param pkgName
	 * @return
	 */
	public Set<ExecutorMethod> findExecutorMethod(String pkgName);
	
	/**
	 * 从 ExecutorMethod 获取 ExecutorMethodInfo 
	 * @param executorMethod
	 * @return
	 */
	public ExecutorMethodInfo getExecutorMethodInfo(ExecutorMethod executorMethod);
	
}
