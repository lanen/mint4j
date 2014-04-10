package evanq.game.infrastructure.mint.commandexecutors;

/**
 * 
 * TODO 在此可以给命令加入拦截器
 * 
 * 这个类是兼容class level 的命令执行器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class CommandExecutionChain {

	private final Object executor;
	
	public CommandExecutionChain(Object exeuctor) {
		this.executor = exeuctor;
	}
	
	public Object getExecutor(){
		return executor;
	}
}
