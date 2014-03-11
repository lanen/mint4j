package evanq.game.cardgame.domain.model;

/**
 * 
 * 职业表
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class Profession {

	
	private int id;
	
	private String name;
	
	private String description;
	
	/**
	 * 力量成长
	 */
	private int perLevelStr;
	
	/**
	 * 敏捷成长
	 */
	private int perLevelDex;
	
	/**
	 * 耐力成长
	 */
	private int perLevelVit;
	
	/**
	 * 智力成长
	 */
	private int perLevelWis;
	
	/**
	 * 
	 */
	private int perHPVit;
	
	/**
	 * 
	 */
	private int perPhyAttStr;
	
	/**
	 * 
	 */
	private int perPhyDefStr;
	
	/**
	 * 
	 */
	private int perPhyDefVit;
	
	/**
	 * 
	 */
	private int perMigAttWis;
	
	/**
	 * 
	 */
	private int perMigDefWis;
	
	/**
	 * 
	 */
	private int perMigDefVit;
	
	/**
	 * 
	 */
	private int perSpeedDex;
	
	/**
	 * 
	 * 普通攻击技能
	 */
	private int ordinarySkill;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPerLevelStr() {
		return perLevelStr;
	}
	
	public void setPerLevelStr(int perLevelStr) {
		this.perLevelStr = perLevelStr;
	}
	
	public int getPerLevelDex() {
		return perLevelDex;
	}
	
	public void setPerLevelDex(int perLevelDex) {
		this.perLevelDex = perLevelDex;
	}
	
	public int getPerLevelVit() {
		return perLevelVit;
	}
	
	public void setPerLevelVit(int perLevelVit) {
		this.perLevelVit = perLevelVit;
	}
	
	public int getPerLevelWis() {
		return perLevelWis;
	}
	
	public void setPerLevelWis(int perLevelWis) {
		this.perLevelWis = perLevelWis;
	}
	
	public int getPerHPVit() {
		return perHPVit;
	}
	
	public void setPerHPVit(int perHPVit) {
		this.perHPVit = perHPVit;
	}
	
	public int getPerPhyAttStr() {
		return perPhyAttStr;
	}
	
	public void setPerPhyAttStr(int perPhyAttStr) {
		this.perPhyAttStr = perPhyAttStr;
	}
	
	public int getPerPhyDefStr() {
		return perPhyDefStr;
	}
	
	public void setPerPhyDefStr(int perPhyDefStr) {
		this.perPhyDefStr = perPhyDefStr;
	}
	
	public int getPerPhyDefVit() {
		return perPhyDefVit;
	}
	
	public void setPerPhyDefVit(int perPhyDefVit) {
		this.perPhyDefVit = perPhyDefVit;
	}
	
	public int getPerMigAttWis() {
		return perMigAttWis;
	}
	
	public void setPerMigAttWis(int perMigAttWis) {
		this.perMigAttWis = perMigAttWis;
	}
	
	public int getPerMigDefWis() {
		return perMigDefWis;
	}
	
	public void setPerMigDefWis(int perMigDefWis) {
		this.perMigDefWis = perMigDefWis;
	}
	
	public int getPerMigDefVit() {
		return perMigDefVit;
	}
	
	public void setPerMigDefVit(int perMigDefVit) {
		this.perMigDefVit = perMigDefVit;
	}
	
	public int getPerSpeedDex() {
		return perSpeedDex;
	}
	
	public void setPerSpeedDex(int perSpeedDex) {
		this.perSpeedDex = perSpeedDex;
	}
	
	public int getOrdinarySkill() {
		return ordinarySkill;
	}
	
	public void setOrdinarySkill(int ordinarySkill) {
		this.ordinarySkill = ordinarySkill;
	}
		
}
