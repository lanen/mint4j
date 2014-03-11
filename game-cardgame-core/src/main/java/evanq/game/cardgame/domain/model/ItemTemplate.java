package evanq.game.cardgame.domain.model;

public class ItemTemplate {

	private int id;
	
	private String name;

	private String description;
	
	/**
	 * 物品的图标
	 */
	private int icon;
	
	/**
	 * 物品类型
	 */
	private int type;
	
	
	/**
	 * 在包裹中的分页编号 1装备 2宝石 3道具;
	 */
	private int itemTag;
	
	/**
	 * 最大堆叠数
	 */
	private int maxOverlay;
	
	/**
	 * 
	 * 最大持久的
	 */
	private int maxDurability;
	
	/**
	 * 物品的等级限制
	 */
	private int levelRequired;
	
	/**
	 * 需要技能
	 */
	private int requiredSkill;
	
	/**
	 * 需要技能等级
	 */
	private int requiredSkillLevel;
	
	/**
	 *  继承触发进入CD
	 */
	private int skillTrigger_1;
	
	/**
	 * CD 时间
	 */
	private int skillCooldown_1;
	
	/**
	 * 类属CD 时间
	 */
	private int skillCatalogCooldown_1;
	
	/**
	 *  继承触发进入CD
	 */
	private int skillTrigger_2;
	
	/**
	 * CD 时间
	 */
	private int skillCooldown_2;
	
	/**
	 * 类属CD 时间
	 */
	private int skillCatalogCooldown_2;
	
	/**
	 *  继承触发进入CD
	 */
	private int skillTrigger_3;
	
	/**
	 * CD 时间
	 */
	private int skillCooldown_3;
	
	/**
	 * 类属CD 时间
	 */
	private int skillCatalogCooldown_3;
	
	/**
	 * 使用类型 1可使用 2不可使用
	 */
	private int useType;
	
	/**
	 * 基础品质 1灰 2白 3绿 4蓝 5紫 6橙 7红
	 */
	private int baseQuality;
	
	/**
	 * 使用效果
	 */
	private String script;
	
	/**
	 * 可否注魂 1不可以 2可以
	 */
	private int canInjection;
	/**
	 * 基础攻击力
	 */
	private int baseAttack;
	/**
	 * 攻击类型 1物理攻击 2魔法攻击
	 */
	private int attackType;
	
	/**
	 * 武器速度
	 */
	private int baseSpeed;
	
	/**
	 * 基础力量
	 */
	private int baseStr;
	
	/**
	 * 基础耐力（体力）
	 */
	private int baseVit;
	
	/**
	 * 基础敏捷
	 */
	private int baseDex;
	
	/**
	 * 基础智力
	 */
	private int baseWis;
	
	/**
	 * 基础物理攻击
	 */
	private int basePhysicalAttack;
	
	/**
	 * 基础魔法攻击
	 */
	private int baseMagicAttack;
	
	/**
	 * 基础物理防御
	 */
	private int basePhysicalDefense;
	
	/**
	 * 基础魔法防御
	 */
	private int baseMagicDefense;
	
	/**
	 * 基础hp追加
	 */
	private int baseHpAdditional;
	
	/**
	 * 基础mp追加
	 */
	private int baseMpAdditional;
	
	/**
	 * 基础命中追加
	 */
	private int baseHitAdditional;
	/**
	 * 基础暴击追加
	 */
	private int baseCritAdditional;
	
	/**
	 * 基础抗暴追加
	 */
	private int baseBlockAdditional;
	
	/**
	 * 基础闪避追加
	 */
	private int baseDodgeAdditional;
	
	/**
	 * 基础速度追加
	 */
	private int baseSpeedAdditional;
	
	/**
	 * 基础特效
	 */
	private String baseEffects;
	
	/**
	 * 装备位置 0=衣服 1=裤子 2=头盔 3=手套 4=靴子 5=护肩 6=项链 7=戒指 8=主武器 9=副武器 10=双手
	 */
	private int bodyType;
	
	/**
	 * 铜币价格
	 */
	private int buyingRateCoin;
	/**
	 * 基础防御
	 */
	private int baseDefense;
	
	/**
	 * 套装的ID
	 */
	private int suiteId;
	
	/**
	 * 可以合成的物品的ID
	 */
	private int compound;
	
	/**
	 * 合成价格
	 */
	private int comprice;
	
	/**
	 * 初始经验值
	 */
	private int ownerexp;
	
	/**
	 * 成长所需的经验
	 */
	private int maxexp;
	
	/**
	 * 成长的物品的模版ID
	 */
	private int growTemp;
	
	/**
	 * 附加技能的ID
	 */
	private int additionSkill;

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

	public int getItemTag() {
		return itemTag;
	}

	public void setItemTag(int itemTag) {
		this.itemTag = itemTag;
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

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public int getBaseStr() {
		return baseStr;
	}

	public void setBaseStr(int baseStr) {
		this.baseStr = baseStr;
	}

	public int getBaseVit() {
		return baseVit;
	}

	public void setBaseVit(int baseVit) {
		this.baseVit = baseVit;
	}

	public int getBaseDex() {
		return baseDex;
	}

	public void setBaseDex(int baseDex) {
		this.baseDex = baseDex;
	}

	public int getBaseWis() {
		return baseWis;
	}

	public void setBaseWis(int baseWis) {
		this.baseWis = baseWis;
	}

	public int getBasePhysicalAttack() {
		return basePhysicalAttack;
	}

	public void setBasePhysicalAttack(int basePhysicalAttack) {
		this.basePhysicalAttack = basePhysicalAttack;
	}

	public int getBaseMagicAttack() {
		return baseMagicAttack;
	}

	public void setBaseMagicAttack(int baseMagicAttack) {
		this.baseMagicAttack = baseMagicAttack;
	}

	public int getBasePhysicalDefense() {
		return basePhysicalDefense;
	}

	public void setBasePhysicalDefense(int basePhysicalDefense) {
		this.basePhysicalDefense = basePhysicalDefense;
	}

	public int getBaseMagicDefense() {
		return baseMagicDefense;
	}

	public void setBaseMagicDefense(int baseMagicDefense) {
		this.baseMagicDefense = baseMagicDefense;
	}

	public int getBaseHpAdditional() {
		return baseHpAdditional;
	}

	public void setBaseHpAdditional(int baseHpAdditional) {
		this.baseHpAdditional = baseHpAdditional;
	}

	public int getBaseMpAdditional() {
		return baseMpAdditional;
	}

	public void setBaseMpAdditional(int baseMpAdditional) {
		this.baseMpAdditional = baseMpAdditional;
	}

	public int getBaseHitAdditional() {
		return baseHitAdditional;
	}

	public void setBaseHitAdditional(int baseHitAdditional) {
		this.baseHitAdditional = baseHitAdditional;
	}

	public int getBaseCritAdditional() {
		return baseCritAdditional;
	}

	public void setBaseCritAdditional(int baseCritAdditional) {
		this.baseCritAdditional = baseCritAdditional;
	}

	public int getBaseBlockAdditional() {
		return baseBlockAdditional;
	}

	public void setBaseBlockAdditional(int baseBlockAdditional) {
		this.baseBlockAdditional = baseBlockAdditional;
	}

	public int getBaseDodgeAdditional() {
		return baseDodgeAdditional;
	}

	public void setBaseDodgeAdditional(int baseDodgeAdditional) {
		this.baseDodgeAdditional = baseDodgeAdditional;
	}

	public int getBaseSpeedAdditional() {
		return baseSpeedAdditional;
	}

	public void setBaseSpeedAdditional(int baseSpeedAdditional) {
		this.baseSpeedAdditional = baseSpeedAdditional;
	}

	public String getBaseEffects() {
		return baseEffects;
	}

	public void setBaseEffects(String baseEffects) {
		this.baseEffects = baseEffects;
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
	
}
