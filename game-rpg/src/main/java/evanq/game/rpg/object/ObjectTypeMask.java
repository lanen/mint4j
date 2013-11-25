package evanq.game.rpg.object;

/**
 * 对象的蒙版，用于对象类属检查
 * 
 * @author Evan
 *
 */
public enum ObjectTypeMask {
	
	
	/**  */
	OBJECT_MASK_OBJECT(0x0001),
	
	/** 物品类 */
	OBJECT_MASK_ITEM(0x0002),
	
	/** 容器类 */
	OBJECT_MASK_ITEM_COUNTAINER(0x0004),
	
	OBJECT_MASK_ENTITY(0x0008),
	
	/** 角色类 */
	OBJECT_MASK_ROLE(0x0010),
	
	/** 游戏静态对象 */
	OBJECT_MASK_GAME_OBJECT(0x0020),
	
	/** 游戏动态对象 */
	OBJECT_MASK_GAME_DYNAMIC_OBJECT(0x0040);
	
	
	private int mask;
	
	ObjectTypeMask(int m){
		this.mask = m;
	}
	public int getValue(){
		return this.mask;
	}
}
