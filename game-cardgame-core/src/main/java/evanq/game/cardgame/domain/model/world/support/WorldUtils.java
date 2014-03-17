package evanq.game.cardgame.domain.model.world.support;

import evanq.game.cardgame.infrastructure.controller.ServiceManager;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class WorldUtils {
	
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

	/**
	 * 
	 * 领域内部的服务层
	 */
	static ServiceManager services;
	
	/**
	 * config framework
	 */
	public static Object cfgFW;
	
	/**
	 * config game.
	 */
	public static Object cfg;
	
	public static ServiceManager services(){
		return services;
	}
}
