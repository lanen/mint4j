package evanq.game.cardgame.application;

import evanq.game.cardgame.domain.model.role.RoleId;

/**
 * 
 * 定义角色在游戏中的行为用例
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface UCRole {

	/**
	 * 
	 * 角色进入游戏
	 * @param roleId
	 */
	public void enterGame(RoleId roleId);
	
	/**
	 * 
	 * 角色离开游戏
	 * @param roleId
	 */
	public void leaveGame(RoleId roleId);
	
	
	/**
	 * 被杀
	 */
	public void wasKill();
	
	/**
	 * 复活
	 */
	public void spawn();
}
