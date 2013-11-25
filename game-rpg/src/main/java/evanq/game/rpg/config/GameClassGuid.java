package evanq.game.rpg.config;

/**
 * 枚举出游戏中的类属的全局唯一ID
 * 
 * 
 * @author Evan
 *
 */
public enum GameClassGuid {
	
	GAME_ITEM(0x0001,"Item"),
	GAME_ROLE(0x0002,"Role"),
	GAME_PET (0x0003,"Pet"),
	GAME_CREATURE(0x0004,"Creature"),
	GAME_TASK(0x0005,"Task"),
	GAME_GROUP(0x0006,"Group"),
	GAME_OBJECT(0x0007,"GameObject"),
	GAME_DYNAMIC_OBJECT(0x0008,"GameDynamicObject"),
	GAME_SCENE(0x0009,"Scene");
	
	
	private int type;
	private String name;
	
	GameClassGuid(int t, String n){
		this.type = t;
		this.name = n;
	}
	
	public int getValue(){
		return this.type;
	}
	
	public String getName(){
		return this.name;
	}
}
