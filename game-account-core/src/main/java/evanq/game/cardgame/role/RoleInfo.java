package evanq.game.cardgame.role;

import java.util.Date;

/**
 * 
 * 角色信息表
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RoleInfo {

	private int id;

	private int name;
	/**
	 * 角色职业
	 */
	private int profession;
	/**
	 * 角色形象
	 */
	private int figure;
	/**
	 * 角色性别
	 */
	private int sex;
	/**
	 * 阵营
	 */
	private int camp;

	/**
	 * 好友数量
	 */
	private int friendCount;

	/**
	 * 当前金币
	 */
	private int coin;
	/**
	 * 当前充值
	 */
	private int gold;

	/**
	 * vip 等级
	 */
	private int vipType;
	/**
	 * vip 经验
	 */
	private int vipExp;

	/**
	 * 能量
	 */
	private int energy;
	
	/**
	 * 
	 */
	private int exp;
	
	/**
	 * 
	 */
	private int level;
	
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

	

	private int sceneId;
	private int position_x;
	private int position_y;
	private int position_z;
	/**
	 * 角色朝向
	 */
	private int orientation;

	/**
	 * 背包大小
	 */
	private int packageSize;

	/**
	 * 角色的说说
	 */
	private int say;
	/**
	 * 阵法
	 */
	private int matrix;
	
	/**
	 * 新手引导步骤
	 */
	private int guideStep;

	private int isOnline;

	private Date createTime;
	
	private Date loginTime;
	
	private Date leaveTime;

	/**
	 * 是否禁言
	 */
	private int silence;

	/**
	 * 声望
	 */
	private int prestige;

	/**
	 * 当前关卡
	 */
	private int mission;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getProfession() {
		return profession;
	}

	public void setProfession(int profession) {
		this.profession = profession;
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

	public int getFriendCount() {
		return friendCount;
	}

	public void setFriendCount(int friendCount) {
		this.friendCount = friendCount;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getVipType() {
		return vipType;
	}

	public void setVipType(int vipType) {
		this.vipType = vipType;
	}

	public int getVipExp() {
		return vipExp;
	}

	public void setVipExp(int vipExp) {
		this.vipExp = vipExp;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}

	public int getPackageSize() {
		return packageSize;
	}

	public void setPackageSize(int packageSize) {
		this.packageSize = packageSize;
	}

	public int getSay() {
		return say;
	}

	public void setSay(int say) {
		this.say = say;
	}

	public int getMatrix() {
		return matrix;
	}

	public void setMatrix(int matrix) {
		this.matrix = matrix;
	}

	public int getGuideStep() {
		return guideStep;
	}

	public void setGuideStep(int guideStep) {
		this.guideStep = guideStep;
	}

	public int getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public int getSilence() {
		return silence;
	}

	public void setSilence(int silence) {
		this.silence = silence;
	}

	public int getPrestige() {
		return prestige;
	}

	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}

	public int getMission() {
		return mission;
	}

	public void setMission(int mission) {
		this.mission = mission;
	}

	public int getPosition_z() {
		return position_z;
	}

	public void setPosition_z(int position_z) {
		this.position_z = position_z;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	
}
