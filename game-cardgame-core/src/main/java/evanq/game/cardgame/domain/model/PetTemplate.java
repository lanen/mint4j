package evanq.game.cardgame.domain.model;

/**
 * 可以理解为 宠物，卡牌，船体。。。
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class PetTemplate {

	private int id;
	
	private String name;
	
	private String description;
	
	/**
	 * 图标类型
	 */
	private int type;
	
	/**
	 * 图标
	 */
	private int icon;
	
	/**
	 * 资源id
	 */
	private int petResource;
	
	/**
	 * 默认0，1：坐骑，2小精灵
	 */
	private int petType;
	
	/**
	 * 默认0，外放跟随。
	 */
	private int petFollow;
	/**
	 * 属性类型 1物理 2魔法
	 */
	private int attibuteType;
	
	/**
	 * General skill 普通技能。默认攻击技能
	 */
	private int ordinarySkill;
	
	
	private int skill_1;
	private int skill_2;
	private int skill_3;
	
	/**
	 * 基础资质等级 1=普通（绿）2=优秀（蓝）3=精良（紫） 4=史诗（金）5=传说（橙）6=逆天（红）
	 */
	private int baseQuality;
	
	
	/**
	 * 力量成长
	 */
	private int strGrowth;
	/**
	 * 智力成长
	 */
	private int wisGrowth;
	/**
	 * 耐力成长
	 */
	private int vitGrowth;
	/**
	 * 敏捷成长
	 */
	private int dexGrowth;
	
	/**
	 * 等级越高说明宠物越厉害
	 */
	private int level;
	
	/**
	 * 宠物购买价格
	 * 
	 * 暂时放在这里，到时候可以令立表单填写各种购买渠道和花费
	 */
	private int coin;
	
	/**
	 * 成长后的模版ID
	 */
	private int growpet;
	
	/**
	 * 初始能提供的能量
	 */
	private int energy;
	
	/**
	 * 成长所需的能量
	 */
	private int maxEnergy;
	
	/**
	 * 提升宠物所需物品ID
	 */
	private int growpetRequiredItem;

	/**
	 * 提升宠物所需物品数量
	 */
	private int growpetRequiredItemCount;
	
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getPetResource() {
		return petResource;
	}

	public void setPetResource(int petResource) {
		this.petResource = petResource;
	}

	public int getAttibuteType() {
		return attibuteType;
	}

	public void setAttibuteType(int attibuteType) {
		this.attibuteType = attibuteType;
	}

	public int getOrdinarySkill() {
		return ordinarySkill;
	}

	public void setOrdinarySkill(int ordinarySkill) {
		this.ordinarySkill = ordinarySkill;
	}

	public int getSkill_1() {
		return skill_1;
	}

	public void setSkill_1(int skill_1) {
		this.skill_1 = skill_1;
	}

	public int getSkill_2() {
		return skill_2;
	}

	public void setSkill_2(int skill_2) {
		this.skill_2 = skill_2;
	}

	public int getSkill_3() {
		return skill_3;
	}

	public void setSkill_3(int skill_3) {
		this.skill_3 = skill_3;
	}

	public int getBaseQuality() {
		return baseQuality;
	}

	public void setBaseQuality(int baseQuality) {
		this.baseQuality = baseQuality;
	}

	public int getStrGrowth() {
		return strGrowth;
	}

	public void setStrGrowth(int strGrowth) {
		this.strGrowth = strGrowth;
	}

	public int getWisGrowth() {
		return wisGrowth;
	}

	public void setWisGrowth(int wisGrowth) {
		this.wisGrowth = wisGrowth;
	}

	public int getVitGrowth() {
		return vitGrowth;
	}

	public void setVitGrowth(int vitGrowth) {
		this.vitGrowth = vitGrowth;
	}

	public int getDexGrowth() {
		return dexGrowth;
	}

	public void setDexGrowth(int dexGrowth) {
		this.dexGrowth = dexGrowth;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGrowpet() {
		return growpet;
	}

	public void setGrowpet(int growpet) {
		this.growpet = growpet;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public int getPetType() {
		return petType;
	}

	public void setPetType(int petType) {
		this.petType = petType;
	}

	public int getPetFollow() {
		return petFollow;
	}

	public void setPetFollow(int petFollow) {
		this.petFollow = petFollow;
	}

	public int getGrowpetRequiredItem() {
		return growpetRequiredItem;
	}

	public void setGrowpetRequiredItem(int growpetRequiredItem) {
		this.growpetRequiredItem = growpetRequiredItem;
	}

	public int getGrowpetRequiredItemCount() {
		return growpetRequiredItemCount;
	}

	public void setGrowpetRequiredItemCount(int growpetRequiredItemCount) {
		this.growpetRequiredItemCount = growpetRequiredItemCount;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}
	
}

