package evanq.game.cardgame.application;

/**
 * 
 * 玩家对角色的操作用例
 * 
 * 类后缀UC 代表 User case
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface UCPlayer {

	/**
	 * 登陆账号
	 */
	public void login();
	
	/**
	 * 退出账号
	 */
	public void logout();
	
	/**
	 * 删除角色
	 */
	public void deleleRole();
	
	/**
	 * 创建角色
	 */
	public void createRole();
	
	/**
	 * 更新角色
	 */
	public void updateRole();
	
	/**
	 * 列出角色
	 */
	public void listRoles();
	
}
