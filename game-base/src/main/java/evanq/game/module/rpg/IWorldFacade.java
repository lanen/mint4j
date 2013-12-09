package evanq.game.module.rpg;

import evanq.game.env.IEnvironment;


/**
 * 
 * @author Evan
 *
 */
public interface IWorldFacade {
	

	/**
	 * @param name 世界名字 
	 * @param environment 运行环境
	 */
	public void start(String name, IEnvironment environment);
	
	
	/**
	 * 
	 * 关闭
	 * 
	 */
	public void stop();
	
}
