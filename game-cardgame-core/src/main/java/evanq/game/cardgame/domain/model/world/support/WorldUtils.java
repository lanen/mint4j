package evanq.game.cardgame.domain.model.world.support;

import evanq.game.cardgame.infrastructure.controller.ControllerManager;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class WorldUtils {

	/**
	 * ÿ�����������ǵ���
	 */
	static ControllerManager controllers;
	
	/**
	 * config framework
	 */
	public static Object cfgFW;
	
	/**
	 * config game.
	 */
	public static Object cfg;
	
	public static ControllerManager controllers(){
		return controllers;
	}
}
