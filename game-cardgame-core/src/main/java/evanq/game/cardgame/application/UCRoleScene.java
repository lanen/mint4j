package evanq.game.cardgame.application;

/**
 * 
 * 角色在场景中用例
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface UCRoleScene {

	/**
	 * 
	 * 进入场景
	 * 
	 */
	public void enterScene();
	
	/**
	 * 移动
	 */
	public void move();
	
	/**
	 * 转移场景到指定场景 
	 */
	public void transformScene();
	
	/**
	 * 在同一场景中转移
	 */
	public void transformInScene();
	
	
}
