package evanq.game.cardgame.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_template")
public class ItemTemplate {

	@Id
	@Column
	private int id;
	
	@Column
	private String name;

	@Column
	private String description;
	
	/**
	 * 物品的图标
	 */
	@Column
	private int icon;
	
	/**
	 * 物品类型
	 */
	@Column
	private int type;
	
	
	/** 
	 * 大类
	 * 在包裹中的分页编号 1装备 2宝石 3道具;
	 */
	@Column
	private int itemType;
	
//	/**
//	 * 小类
//	 * 物品分类
//	 */
//	@Column
//	private int itemSubType;
	/**
	 * 最大堆叠数
	 */
	@Column
	private int maxOverlay;
	
	
	/**
	 * 
	 * 最大持久的
	 */
	@Column
	private int maxDurability;
	
	/**
	 * 物品的等级限制
	 */
	@Column
	private int levelRequired;
	
	/**
	 * 需要技能
	 */
	@Column
	private int requiredSkill;
	
	/**
	 * 需要力量
	 */
	@Column
	private int requiredStr;
	/**
	 * 需要耐力
	 */
	@Column
	private int requiredVit;
	/**
	 * 需要智力
	 */
	@Column
	private int requiredWis;
	/**
	 * 需要敏捷
	 */
	@Column
	private int requiredDex;
	
	/**
	 * 需要技能等级
	 */
	@Column
	private int requiredSkillLevel;
	
	/**
	 *  继承触发进入CD
	 */
	@Column
	private int skillTrigger_1;
	
	/**
	 * CD 时间
	 */
	@Column
	private int skillCooldown_1;
	
	/**
	 * 类属CD 时间
	 */
	@Column
	private int skillCatalogCooldown_1;
	
	/**
	 *  继承触发进入CD
	 */
	@Column
	private int skillTrigger_2;
	
	/**
	 * CD 时间
	 */
	@Column
	private int skillCooldown_2;
	
	/**
	 * 类属CD 时间
	 */
	@Column
	private int skillCatalogCooldown_2;
	
	/**
	 *  继承触发进入CD
	 */
	@Column
	private int skillTrigger_3;
	
	/**
	 * CD 时间
	 */
	@Column
	private int skillCooldown_3;
	
	/**
	 * 类属CD 时间
	 */
	@Column
	private int skillCatalogCooldown_3;
	
	/**
	 * 使用类型 1可使用 2不可使用
	 */
	@Column
	private int useType;
	
	/**
	 * 基础品质 1灰 2白 3绿 4蓝 5紫 6橙 7红
	 */
	@Column
	private int baseQuality;
	
	/**
	 * 使用效果
	 */
	@Column
	private String script;
	
	/**
	 * 可否注魂 1不可以 2可以
	 */
	@Column
	private int canInjection;
	/**
	 * 基础攻击力
	 */
	@Deprecated
	private int baseAttack;
	/**
	 * 攻击类型 1物理攻击 2魔法攻击
	 */
	@Column
	private int attackType;
	/**
	 * 武器速度
	 */
	@Column
	private float baseSpeed;
	
	/**
	 * 基础力量
	 */
	@Column
	private float baseStr;
	
	/**
	 * 基础耐力（体力）
	 */
	@Column
	private float baseVit;
	
	/**
	 * 基础敏捷
	 */
	@Column
	private float baseDex;
	
	/**
	 * 基础智力
	 */
	@Column
	private float baseWis;
	
	/**
	 * 基础物理攻击
	 */
	@Column
	private float basePhysicalAttack;
	
	/**
	 * 基础魔法攻击
	 */
	@Column
	private float baseMagicAttack;
	
	/**
	 * 基础物理防御
	 */
	@Column
	private float basePhysicalDefense;
	
	/**
	 * 基础魔法防御
	 */
	@Column
	private float baseMagicDefense;
	
	/**
	 * 基础hp追加
	 */
	@Column
	private float baseHpAdditional;
	
	/**
	 * 基础mp追加
	 */
	@Column
	private float baseMpAdditional;
	
	/**
	 * 基础命中追加
	 */
	@Column
	private float baseHitAdditional;
	/**
	 * 基础暴击追加
	 */
	@Column
	private float baseCritAdditional;
	
	/**
	 * 基础抗暴追加
	 */
	@Column
	private float baseBlockAdditional;
	
	/**
	 * 基础闪避追加
	 */
	@Column
	private float baseDodgeAdditional;
	
	/**
	 * 基础速度追加
	 */
	@Column
	private float baseSpeedAdditional;
	
	
	/**
	 * 装备位置 0=衣服 1=裤子 2=头盔 3=手套 4=靴子 5=护肩 6=项链 7=戒指 8=主武器 9=副武器 10=双手
	 */
	@Column
	private int bodyType;
	
	/**
	 * 铜币价格
	 */
	@Column
	private int buyingRateCoin;
	/**
	 * 基础防御
	 */
	@Deprecated
	private int baseDefense;
	
	/**
	 * 套装的ID
	 */
	@Column
	private int suiteId;
	
	/**
	 * 可以合成的物品的ID
	 */
	@Column
	private int compound;
	
	/**
	 * 合成价格
	 */
	@Column
	private int comprice;
	
	/**
	 * 初始经验值
	 */
	private int ownerexp;
	
	/**
	 * 成长所需的经验
	 */
	@Column
	private int maxexp;
	
	/**
	 * 成长的物品的模版ID
	 */
	@Column
	private int growTemp;
	
	/**
	 * 附加技能的ID
	 */
	@Column
	private int additionSkill;
	
	/**
	 * 攻击附加效果
	 */
	@Column
	private int additionEffect;

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


	public int getMaxOverlay() {
		return maxOverlay;
	}

	public void setMaxOverlay(int maxOverlay) {
		this.maxOverlay = maxOverlay;
	}

	public int getLevelRequired() {
		return levelRequired;
	}

	public void setLevelRequired(int levelRequired) {
		this.levelRequired = levelRequired;
	}

	public int getUseType() {
		return useType;
	}

	public void setUseType(int useType) {
		this.useType = useType;
	}

	public int getBaseQuality() {
		return baseQuality;
	}

	public void setBaseQuality(int baseQuality) {
		this.baseQuality = baseQuality;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public int getCanInjection() {
		return canInjection;
	}

	public void setCanInjection(int canInjection) {
		this.canInjection = canInjection;
	}

	public int getBaseAttack() {
		return baseAttack;
	}

	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	public int getAttackType() {
		return attackType;
	}

	public void setAttackType(int attackType) {
		this.attackType = attackType;
	}


	public float getBaseSpeed() {
		return baseSpeed;
	}

	public void setBaseSpeed(float baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public void setBaseSpeedAdditional(int baseSpeedAdditional) {
		this.baseSpeedAdditional = baseSpeedAdditional;
	}

	public int getBodyType() {
		return bodyType;
	}

	public void setBodyType(int bodyType) {
		this.bodyType = bodyType;
	}

	public int getBuyingRateCoin() {
		return buyingRateCoin;
	}

	public void setBuyingRateCoin(int buyingRateCoin) {
		this.buyingRateCoin = buyingRateCoin;
	}

	public int getBaseDefense() {
		return baseDefense;
	}

	public void setBaseDefense(int baseDefense) {
		this.baseDefense = baseDefense;
	}

	public float getBaseStr() {
		return baseStr;
	}

	public void setBaseStr(float baseStr) {
		this.baseStr = baseStr;
	}

	public float getBaseVit() {
		return baseVit;
	}

	public void setBaseVit(float baseVit) {
		this.baseVit = baseVit;
	}

	public float getBaseDex() {
		return baseDex;
	}

	public void setBaseDex(float baseDex) {
		this.baseDex = baseDex;
	}

	public float getBaseWis() {
		return baseWis;
	}

	public void setBaseWis(float baseWis) {
		this.baseWis = baseWis;
	}

	public float getBasePhysicalAttack() {
		return basePhysicalAttack;
	}

	public void setBasePhysicalAttack(float basePhysicalAttack) {
		this.basePhysicalAttack = basePhysicalAttack;
	}

	public float getBaseMagicAttack() {
		return baseMagicAttack;
	}

	public void setBaseMagicAttack(float baseMagicAttack) {
		this.baseMagicAttack = baseMagicAttack;
	}

	public float getBasePhysicalDefense() {
		return basePhysicalDefense;
	}

	public void setBasePhysicalDefense(float basePhysicalDefense) {
		this.basePhysicalDefense = basePhysicalDefense;
	}

	public float getBaseMagicDefense() {
		return baseMagicDefense;
	}

	public void setBaseMagicDefense(float baseMagicDefense) {
		this.baseMagicDefense = baseMagicDefense;
	}

	public float getBaseHpAdditional() {
		return baseHpAdditional;
	}

	public void setBaseHpAdditional(float baseHpAdditional) {
		this.baseHpAdditional = baseHpAdditional;
	}

	public float getBaseMpAdditional() {
		return baseMpAdditional;
	}

	public void setBaseMpAdditional(float baseMpAdditional) {
		this.baseMpAdditional = baseMpAdditional;
	}

	public float getBaseHitAdditional() {
		return baseHitAdditional;
	}

	public void setBaseHitAdditional(float baseHitAdditional) {
		this.baseHitAdditional = baseHitAdditional;
	}

	public float getBaseCritAdditional() {
		return baseCritAdditional;
	}

	public void setBaseCritAdditional(float baseCritAdditional) {
		this.baseCritAdditional = baseCritAdditional;
	}

	public float getBaseBlockAdditional() {
		return baseBlockAdditional;
	}

	public void setBaseBlockAdditional(float baseBlockAdditional) {
		this.baseBlockAdditional = baseBlockAdditional;
	}

	public float getBaseDodgeAdditional() {
		return baseDodgeAdditional;
	}

	public void setBaseDodgeAdditional(float baseDodgeAdditional) {
		this.baseDodgeAdditional = baseDodgeAdditional;
	}

	public float getBaseSpeedAdditional() {
		return baseSpeedAdditional;
	}

	public void setBaseSpeedAdditional(float baseSpeedAdditional) {
		this.baseSpeedAdditional = baseSpeedAdditional;
	}

	public int getSuiteId() {
		return suiteId;
	}

	public void setSuiteId(int suiteId) {
		this.suiteId = suiteId;
	}

	public int getCompound() {
		return compound;
	}

	public void setCompound(int compound) {
		this.compound = compound;
	}

	public int getComprice() {
		return comprice;
	}

	public void setComprice(int comprice) {
		this.comprice = comprice;
	}

	public int getOwnerexp() {
		return ownerexp;
	}

	public void setOwnerexp(int ownerexp) {
		this.ownerexp = ownerexp;
	}

	public int getMaxexp() {
		return maxexp;
	}

	public void setMaxexp(int maxexp) {
		this.maxexp = maxexp;
	}

	public int getGrowTemp() {
		return growTemp;
	}

	public void setGrowTemp(int growTemp) {
		this.growTemp = growTemp;
	}

	
	public int getRequiredSkill() {
		return requiredSkill;
	}

	public void setRequiredSkill(int requiredSkill) {
		this.requiredSkill = requiredSkill;
	}

	public int getRequiredSkillLevel() {
		return requiredSkillLevel;
	}

	public void setRequiredSkillLevel(int requiredSkillLevel) {
		this.requiredSkillLevel = requiredSkillLevel;
	}

	public int getAdditionSkill() {
		return additionSkill;
	}

	public void setAdditionSkill(int additionSkill) {
		this.additionSkill = additionSkill;
	}

	public int getMaxDurability() {
		return maxDurability;
	}

	public void setMaxDurability(int maxDurability) {
		this.maxDurability = maxDurability;
	}

	public int getSkillTrigger_1() {
		return skillTrigger_1;
	}

	public void setSkillTrigger_1(int skillTrigger_1) {
		this.skillTrigger_1 = skillTrigger_1;
	}

	public int getSkillCooldown_1() {
		return skillCooldown_1;
	}

	public void setSkillCooldown_1(int skillCooldown_1) {
		this.skillCooldown_1 = skillCooldown_1;
	}

	public int getSkillCatalogCooldown_1() {
		return skillCatalogCooldown_1;
	}

	public void setSkillCatalogCooldown_1(int skillCatalogCooldown_1) {
		this.skillCatalogCooldown_1 = skillCatalogCooldown_1;
	}

	public int getSkillTrigger_2() {
		return skillTrigger_2;
	}

	public void setSkillTrigger_2(int skillTrigger_2) {
		this.skillTrigger_2 = skillTrigger_2;
	}

	public int getSkillCooldown_2() {
		return skillCooldown_2;
	}

	public void setSkillCooldown_2(int skillCooldown_2) {
		this.skillCooldown_2 = skillCooldown_2;
	}

	public int getSkillCatalogCooldown_2() {
		return skillCatalogCooldown_2;
	}

	public void setSkillCatalogCooldown_2(int skillCatalogCooldown_2) {
		this.skillCatalogCooldown_2 = skillCatalogCooldown_2;
	}

	public int getSkillTrigger_3() {
		return skillTrigger_3;
	}

	public void setSkillTrigger_3(int skillTrigger_3) {
		this.skillTrigger_3 = skillTrigger_3;
	}

	public int getSkillCooldown_3() {
		return skillCooldown_3;
	}

	public void setSkillCooldown_3(int skillCooldown_3) {
		this.skillCooldown_3 = skillCooldown_3;
	}

	public int getSkillCatalogCooldown_3() {
		return skillCatalogCooldown_3;
	}

	public void setSkillCatalogCooldown_3(int skillCatalogCooldown_3) {
		this.skillCatalogCooldown_3 = skillCatalogCooldown_3;
	}

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}


	public int getRequiredStr() {
		return requiredStr;
	}

	public void setRequiredStr(int requiredStr) {
		this.requiredStr = requiredStr;
	}

	public int getRequiredVit() {
		return requiredVit;
	}

	public void setRequiredVit(int requiredVit) {
		this.requiredVit = requiredVit;
	}

	public int getRequiredWis() {
		return requiredWis;
	}

	public void setRequiredWis(int requiredWis) {
		this.requiredWis = requiredWis;
	}

	public int getRequiredDex() {
		return requiredDex;
	}

	public void setRequiredDex(int requiredDex) {
		this.requiredDex = requiredDex;
	}

	public int getAdditionEffect() {
		return additionEffect;
	}

	public void setAdditionEffect(int additionEffect) {
		this.additionEffect = additionEffect;
	}	
	
}
