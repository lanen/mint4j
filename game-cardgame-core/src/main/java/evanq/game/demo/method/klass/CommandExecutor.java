package evanq.game.demo.method.klass;

/**
 * 
 * 类级别的命令处理器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface CommandExecutor<C> {

	public void execute(C command);
	
}
