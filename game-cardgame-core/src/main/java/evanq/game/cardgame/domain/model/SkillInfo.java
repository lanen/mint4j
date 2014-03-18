package evanq.game.cardgame.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 技能信息
 * @author Evan cppmain@gmail.com
 *
 */
@Entity
@Table(name="skill_info")
public class SkillInfo {

	@Id
	@Column
	/**
	 * 技能ID
	 */
	private int skillId;
	
	/**
	 * 技能名称
	 */
	@Column
	private String skillName;
	
	/**
	 * 技能组
	 */
	@Column
	private int skillGroup;
	
	/**
	 * 技能等级
	 */
	@Column
	private int level;
	
	/**
	 * 技能图标
	 */
	@Column
	private int icon;
	
	/**
	 * 技能图标类型
	 */
	@Column
	private int type;
	
	/**
	 * 技能类型
	 */
	@Column
	private int skillType;
	
	/**
	 * 职业限制
	 */
	@Column
	private int profession;
	
	/**
	 * 技能描述
	 */
	private String skillDesc;
	

	/**
	 * 技能所需武器
	 */
	@Column
	private int weaponRequired;
	@Column
	private int weaponTypeRequired;
	/**
	 * 技能所需等级
	 */
	
	@Column
	private int levelRequired;
	
	/**
	 * 技能所需物品
	 */
	@Column
	private int itemRequired;
	
	/**
	 * 技能所需物品数量
	 */
	@Column
	private int itemCountRequired;
	
	/**
	 * 升级等级所需金钱
	 */
	@Column
	private int levelUpMoney;
	
	/**
	 * 主动；被动
	 */
	@Column
	private int castType;
	
	/**
	 * CD 时间
	 */
	@Column
	private int castCD;
	
	/**
	 * 技能的距离类型 1远程 2近身
	 */
	@Column
	private int distanceType;
	
	/**
	 * 技能的范围类型 1单体 2全体 ..
	 */
	@Column
	private int rangeType;
	
	/**
	 * 技能的属性类型 1物理 2魔法
	 */
	@Column
	private int attibuteType;
	
	/**
	 * 技能的目标类型 1=自己 2=队友 3=敌方
	 */
	@Column
	private int targetType;

	/**
	 * 技能能量消耗
	 */
	@Column
	private int expendMp;
	
	/**
	 * 技能血量消耗
	 */
	@Column
	private int expendHp;
	
	/**
	 * 技能的效果ID
	 */
	@Column
	private int effectId;
	
	/**
	 * 技能的释放特效
	 */
	@Column
	private int castEffectId;

	/**
	 * 技能的承受特效
	 */
	@Column
	private int hitEffectId;
	
	/**
	 * 技能的投射特效
	 */
	@Column
	private int flyEffectId;

	/**
	 * 全屏特效
	 */
	@Column
	private int aoeEffectId;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getSkillGroup() {
		return skillGroup;
	}

	public void setSkillGroup(int skillGroup) {
		this.skillGroup = skillGroup;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSkillType() {
		return skillType;
	}

	public void setSkillType(int skillType) {
		this.skillType = skillType;
	}

	public int getProfession() {
		return profession;
	}

	public void setProfession(int profession) {
		this.profession = profession;
	}

	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

	public int getWeaponRequired() {
		return weaponRequired;
	}

	public void setWeaponRequired(int weaponRequired) {
		this.weaponRequired = weaponRequired;
	}

	public int getLevelRequired() {
		return levelRequired;
	}

	public void setLevelRequired(int levelRequired) {
		this.levelRequired = levelRequired;
	}

	public int getItemRequired() {
		return itemRequired;
	}

	public void setItemRequired(int itemRequired) {
		this.itemRequired = itemRequired;
	}

	public int getItemCountRequired() {
		return itemCountRequired;
	}

	public void setItemCountRequired(int itemCountRequired) {
		this.itemCountRequired = itemCountRequired;
	}

	public int getLevelUpMoney() {
		return levelUpMoney;
	}

	public void setLevelUpMoney(int levelUpMoney) {
		this.levelUpMoney = levelUpMoney;
	}

	public int getCastType() {
		return castType;
	}

	public void setCastType(int castType) {
		this.castType = castType;
	}

	public int getCastCD() {
		return castCD;
	}

	public void setCastCD(int castCD) {
		this.castCD = castCD;
	}

	public int getDistanceType() {
		return distanceType;
	}

	public void setDistanceType(int distanceType) {
		this.distanceType = distanceType;
	}

	public int getRangeType() {
		return rangeType;
	}

	public void setRangeType(int rangeType) {
		this.rangeType = rangeType;
	}

	public int getAttibuteType() {
		return attibuteType;
	}

	public void setAttibuteType(int attibuteType) {
		this.attibuteType = attibuteType;
	}

	public int getTargetType() {
		return targetType;
	}

	public void setTargetType(int targetType) {
		this.targetType = targetType;
	}

	public int getExpendMp() {
		return expendMp;
	}

	public void setExpendMp(int expendMp) {
		this.expendMp = expendMp;
	}

	public int getExpendHp() {
		return expendHp;
	}

	public void setExpendHp(int expendHp) {
		this.expendHp = expendHp;
	}

	public int getEffectId() {
		return effectId;
	}

	public void setEffectId(int effectId) {
		this.effectId = effectId;
	}

	public int getCastEffectId() {
		return castEffectId;
	}

	public void setCastEffectId(int castEffectId) {
		this.castEffectId = castEffectId;
	}

	public int getHitEffectId() {
		return hitEffectId;
	}

	public void setHitEffectId(int hitEffectId) {
		this.hitEffectId = hitEffectId;
	}

	public int getFlyEffectId() {
		return flyEffectId;
	}

	public void setFlyEffectId(int flyEffectId) {
		this.flyEffectId = flyEffectId;
	}

	public int getAoeEffectId() {
		return aoeEffectId;
	}

	public void setAoeEffectId(int aoeEffectId) {
		this.aoeEffectId = aoeEffectId;
	}

	public int getWeaponTypeRequired() {
		return weaponTypeRequired;
	}

	public void setWeaponTypeRequired(int weaponTypeRequired) {
		this.weaponTypeRequired = weaponTypeRequired;
	}
	
}
