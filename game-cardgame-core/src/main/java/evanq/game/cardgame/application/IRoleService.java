package evanq.game.cardgame.application;

import evanq.game.cardgame.domain.model.role.RoleId;

/**
 * 
 * 定义角色在游戏中的行为用例
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface IRoleService {

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
	
}
