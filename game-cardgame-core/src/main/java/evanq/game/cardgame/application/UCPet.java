package evanq.game.cardgame.application;

import evanq.game.cardgame.domain.model.role.RoleId;

public interface UCPet {
	/**
	 * 
	 * 进入游戏
	 * @param roleId
	 */
	public void enterGame(RoleId roleId);
	
	/**
	 * 
	 * 离开游戏
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
	
	/**
	 * 跟随
	 */
	public void follow();

	/**
	 * 休息
	 */
	public void rest();
}
