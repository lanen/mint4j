package evanq.game.cardgame;


public class CreatureTemplate {

	private int id;
	
	private int icon;
	private int iconType;
	private int resourceId;
	private String name;
	
	
	/**
	 * NPC,CREATERE,BUILDING,尸体
	 */
	private int type;
	
	/**
	 * 形象
	 */
	private int figure;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 阵营
	 */
	private int camp;


	/**
	 * 当前最小金币
	 */
	private int minDropCoin;
	/**
	 * 当前最大金币
	 */
	private int maxDropCoin;


	
	/**
	 * 
	 */
	private int exp;
	
	/**
	 * 最大等级
	 */
	private int maxLevel;
	
	/**
	 * 最小等级
	 */
	private int minLevel;
	
	/**
	 * 
	 */
	private int hp;
	
	/**
	 * 
	 */
	private int maxHp;
	/**
	 * 
	 */
	private int mp;
	/**
	 * 
	 */
	private int maxMp;

	/**
	 * 
	 */
	private int baseStr;
	private int baseVit;
	private int baseDex;
	private int baseWis;

	/**
	 * 
	 */
	private int phyAttStr;
	
	/**
	 * 
	 */
	private int phyDefStr;
	
	/**
	 * 
	 */
	private int phyDefVit;
	
	/**
	 * 
	 */
	private int migicAttWis;
	
	/**
	 * 
	 */
	private int migicDefWis;
	
	/**
	 * 
	 */
	private int migicDefVit;
	
	/**
	 * 
	 */
	private int speedDex;

	/**
	 * 角色的说说
	 */
	private int say;
	
	
	private int attackTime;
	
	private int speedwalk;
	private int speedrun;
	
	/////
	private int header;
	private int body;
	private int belt;
	private int trousers;
	private int shoes;
	private int bracer;
	private int cloak;
	private int necklace;
	private int waist;
	private int weapon_1;
	private int weapon_2;
	/////
	
	/**
	 * General skill 普通技能。默认攻击技能
	 */
	private int ordinarySkill;
	
	
	private int skill_1;
	private int skill_2;
	private int skill_3;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getIconType() {
		return iconType;
	}

	public void setIconType(int iconType) {
		this.iconType = iconType;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getFigure() {
		return figure;
	}

	public void setFigure(int figure) {
		this.figure = figure;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getCamp() {
		return camp;
	}

	public void setCamp(int camp) {
		this.camp = camp;
	}

	public int getMinDropCoin() {
		return minDropCoin;
	}

	public void setMinDropCoin(int minDropCoin) {
		this.minDropCoin = minDropCoin;
	}

	public int getMaxDropCoin() {
		return maxDropCoin;
	}

	public void setMaxDropCoin(int maxDropCoin) {
		this.maxDropCoin = maxDropCoin;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public int getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
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

	public int getPhyAttStr() {
		return phyAttStr;
	}

	public void setPhyAttStr(int phyAttStr) {
		this.phyAttStr = phyAttStr;
	}

	public int getPhyDefStr() {
		return phyDefStr;
	}

	public void setPhyDefStr(int phyDefStr) {
		this.phyDefStr = phyDefStr;
	}

	public int getPhyDefVit() {
		return phyDefVit;
	}

	public void setPhyDefVit(int phyDefVit) {
		this.phyDefVit = phyDefVit;
	}

	public int getMigicAttWis() {
		return migicAttWis;
	}

	public void setMigicAttWis(int migicAttWis) {
		this.migicAttWis = migicAttWis;
	}

	public int getMigicDefWis() {
		return migicDefWis;
	}

	public void setMigicDefWis(int migicDefWis) {
		this.migicDefWis = migicDefWis;
	}

	public int getMigicDefVit() {
		return migicDefVit;
	}

	public void setMigicDefVit(int migicDefVit) {
		this.migicDefVit = migicDefVit;
	}

	public int getSpeedDex() {
		return speedDex;
	}

	public void setSpeedDex(int speedDex) {
		this.speedDex = speedDex;
	}

	public int getSay() {
		return say;
	}

	public void setSay(int say) {
		this.say = say;
	}

	public int getAttackTime() {
		return attackTime;
	}

	public void setAttackTime(int attackTime) {
		this.attackTime = attackTime;
	}

	public int getSpeedwalk() {
		return speedwalk;
	}

	public void setSpeedwalk(int speedwalk) {
		this.speedwalk = speedwalk;
	}

	public int getSpeedrun() {
		return speedrun;
	}

	public void setSpeedrun(int speedrun) {
		this.speedrun = speedrun;
	}

	public int getHeader() {
		return header;
	}

	public void setHeader(int header) {
		this.header = header;
	}

	public int getBody() {
		return body;
	}

	public void setBody(int body) {
		this.body = body;
	}

	public int getBelt() {
		return belt;
	}

	public void setBelt(int belt) {
		this.belt = belt;
	}

	public int getTrousers() {
		return trousers;
	}

	public void setTrousers(int trousers) {
		this.trousers = trousers;
	}

	public int getShoes() {
		return shoes;
	}

	public void setShoes(int shoes) {
		this.shoes = shoes;
	}

	public int getBracer() {
		return bracer;
	}

	public void setBracer(int bracer) {
		this.bracer = bracer;
	}

	public int getCloak() {
		return cloak;
	}

	public void setCloak(int cloak) {
		this.cloak = cloak;
	}

	public int getNecklace() {
		return necklace;
	}

	public void setNecklace(int necklace) {
		this.necklace = necklace;
	}

	public int getWaist() {
		return waist;
	}

	public void setWaist(int waist) {
		this.waist = waist;
	}

	public int getWeapon_1() {
		return weapon_1;
	}

	public void setWeapon_1(int weapon_1) {
		this.weapon_1 = weapon_1;
	}

	public int getWeapon_2() {
		return weapon_2;
	}

	public void setWeapon_2(int weapon_2) {
		this.weapon_2 = weapon_2;
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
	
}
