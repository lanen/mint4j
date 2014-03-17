package evanq.game.cardgame.application;

/**
 * 角色物品管理
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface UCRoleItemManage {

	
	/**
	 * 打开背包
	 */
	public void openPackege();
	
	/**
	 * 打开装备
	 */
	public void openEquip();
	
	
	/**
	 * 丢弃物品
	 */
	public void dropItem();
	
	/**
	 * 使用物品
	 */
	public void useItem();

	/**
	 * 移动物品
	 */
	public void moveItem();

	/**
	 * 接收物品
	 */
	public void receiveItem();
	
	/**
	 * 购买物品 
	 */
	public void buyItem();
	

}
