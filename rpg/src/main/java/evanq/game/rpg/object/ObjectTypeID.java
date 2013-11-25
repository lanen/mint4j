package evanq.game.rpg.object;

/**
 * 对象类属
 * 
 * 为能够清晰描述游戏开发中出现的对象定义类属
 * 
 * @author Evan
 *
 */
public enum ObjectTypeID {
	/**  */
	OBJECT(0),
	
	/** 物品类 */
	ITEM(1),
	
	/** 容器类 */
	ITEM_COUNTAINER(2),
	
	ENTITY(3),
	
	/** 角色类 */
	ROLE(4),
	
	/** 游戏静态对象 */
	GAME_OBJECT(5),
	
	/** 游戏动态对象 */
	GAME_DYNAMIC_OBJECT(6);
	
	private int value;
	
	ObjectTypeID(int theValue){
		this.value = theValue;
	}
	public int getValue(){
		return value;
	}
}
