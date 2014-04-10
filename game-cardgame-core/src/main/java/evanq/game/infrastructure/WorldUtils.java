package evanq.game.infrastructure;

import org.apache.commons.lang.NullArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.infrastructure.mint.BeanResolver;
import evanq.game.infrastructure.mint.commandexecutors.CommandExecutorResolver;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class WorldUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(WorldUtils.class);
	
	//记录了类初始化的时间
	private static final long START_TIME = System.nanoTime();

	static long nanoTime() {
		//返回运行的时间
		return System.nanoTime() - START_TIME;
	}
	
	//到期时间
	static long deadlineNanos(long delay) {
		return nanoTime() + delay;
	}

	
	/////////////////////////////////////////////
	private static BeanResolver beanResolver;
	
	public static BeanResolver beanResolver(){
		return beanResolver;
	}
	
	public static void setBeanResolver(BeanResolver resolver){
		if(null == resolver){
			throw new NullArgumentException("resolver");
		}
		if(null != beanResolver && !beanResolver.equals(resolver)){
			logger.info("替换 BeanResolver");
		}
		
		beanResolver = resolver;
	}
	/////////////////////////////////////////////
	private static CommandExecutorResolver commandExecutorResolver;
	public static CommandExecutorResolver commandExecutorResolver(){
		return commandExecutorResolver;
	}
	public static void setCommandExecutorResolver(CommandExecutorResolver resolver){
		if(null == resolver){
			throw new NullArgumentException("CommandExecutorResolver is null");
		}
		if(null != commandExecutorResolver && !commandExecutorResolver.equals(resolver)){
			logger.info("替换 commandExecutorResolver");
		}
		
		commandExecutorResolver = resolver;
	}
	
	/////////////////////////////////////////////
}
