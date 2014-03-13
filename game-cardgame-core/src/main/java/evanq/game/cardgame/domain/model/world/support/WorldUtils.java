package evanq.game.cardgame.domain.model.world.support;

import evanq.game.cardgame.infrastructure.controller.ServiceManager;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class WorldUtils {


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
