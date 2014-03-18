package evanq.game.cardgame.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 职业表
 * 
 * @author Evan cppmain@gmail.com
 *
 */
@Entity
@Table(name="profession")
public class Profession {

	@Id
	@Column
	private int id;

	@Column
	private String name;
	
	@Column
	private String description;
	
	/**
	 * 力量成长
	 */
	@Column
	private float perLevelStr;
	
	/**
	 * 敏捷成长
	 */
	@Column
	private float perLevelDex;
	
	/**
	 * 耐力成长
	 */
	@Column
	private float perLevelVit;
	
	/**
	 * 智力成长
	 */
	@Column
	private float perLevelWis;
	
	/**
	 * 职业耐力对血量加成
	 */
	@Column
	private float perHPVit;
	
	/**
	 * 职业力量对物理攻击加成
	 */
	@Column
	private float perPhyAttStr;
	
	/**
	 * 职业力量对物理防御加成
	 */
	@Column
	private float perPhyDefStr;
	
	/**
	 * 耐力对物理防御加成
	 */
	@Column
	private float perPhyDefVit;
	
	/**
	 * 智力对魔法攻击加成
	 */
	@Column
	private float perMigAttWis;
	
	/**
	 * 智力对魔法防御加成
	 */
	@Column
	private float perMigDefWis;
	
	/**
	 * 耐力对魔法防御加成
	 */
	@Column
	private float perMigDefVit;
	
	/**
	 * 敏捷对速度加成
	 */
	@Column
	private float perSpeedDex;
	
	/**
	 * 
	 * 普通攻击技能
	 */
	@Column
	private int ordinarySkill;
	
	/**
	 * 职业升级脚本绑定
	 * 暂时一个思路
	 * 天赋
	 */
	private String upgradeScript;
	
	//攻击距离 ： 如果如果需要增加

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

	public float getPerLevelStr() {
		return perLevelStr;
	}

	public void setPerLevelStr(float perLevelStr) {
		this.perLevelStr = perLevelStr;
	}

	public float getPerLevelDex() {
		return perLevelDex;
	}

	public void setPerLevelDex(float perLevelDex) {
		this.perLevelDex = perLevelDex;
	}

	public float getPerLevelVit() {
		return perLevelVit;
	}

	public void setPerLevelVit(float perLevelVit) {
		this.perLevelVit = perLevelVit;
	}

	public float getPerLevelWis() {
		return perLevelWis;
	}

	public void setPerLevelWis(float perLevelWis) {
		this.perLevelWis = perLevelWis;
	}

	public float getPerHPVit() {
		return perHPVit;
	}

	public void setPerHPVit(float perHPVit) {
		this.perHPVit = perHPVit;
	}

	public float getPerPhyAttStr() {
		return perPhyAttStr;
	}

	public void setPerPhyAttStr(float perPhyAttStr) {
		this.perPhyAttStr = perPhyAttStr;
	}

	public float getPerPhyDefStr() {
		return perPhyDefStr;
	}

	public void setPerPhyDefStr(float perPhyDefStr) {
		this.perPhyDefStr = perPhyDefStr;
	}

	public float getPerPhyDefVit() {
		return perPhyDefVit;
	}

	public void setPerPhyDefVit(float perPhyDefVit) {
		this.perPhyDefVit = perPhyDefVit;
	}

	public float getPerMigAttWis() {
		return perMigAttWis;
	}

	public void setPerMigAttWis(float perMigAttWis) {
		this.perMigAttWis = perMigAttWis;
	}

	public float getPerMigDefWis() {
		return perMigDefWis;
	}

	public void setPerMigDefWis(float perMigDefWis) {
		this.perMigDefWis = perMigDefWis;
	}

	public float getPerMigDefVit() {
		return perMigDefVit;
	}

	public void setPerMigDefVit(float perMigDefVit) {
		this.perMigDefVit = perMigDefVit;
	}

	public float getPerSpeedDex() {
		return perSpeedDex;
	}

	public void setPerSpeedDex(float perSpeedDex) {
		this.perSpeedDex = perSpeedDex;
	}

	public int getOrdinarySkill() {
		return ordinarySkill;
	}

	public void setOrdinarySkill(int ordinarySkill) {
		this.ordinarySkill = ordinarySkill;
	}
}
