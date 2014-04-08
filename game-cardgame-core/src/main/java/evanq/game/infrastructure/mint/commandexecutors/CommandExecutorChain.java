package evanq.game.infrastructure.mint.commandexecutors;

/**
 * 
 * TODO 在此可以给命令加入拦截器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class CommandExecutorChain {

	private final Object executor;
	
	public CommandExecutorChain(Object exeuctor) {
		this.executor = exeuctor;
	}
	
	public Object getExecutor(){
		return executor;
	}
}
