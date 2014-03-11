package evanq.game.cardgame.domain.model;

import java.util.Date;

/**
 * 
 * 副本模板
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class InstanceTemplate {

	private int id;
	
	private String name;
	
	private String description;
	
	private int type;
	
	private int hard;
	
	private int sceneId;
	
	private Date startime;
	
	private Date endtime;
	
	private int upLevle;
	private int downLevle;
	
	
	private int props;
	private int guildLevel;
	private int pknum;
	private int energy;
	
	private int teamState;
	/**
	 * 队伍上限
	 * */
	private int teammax;

	/**
	 * 队伍人数下限
	 */
	private int teammin;
	
	/**
	 * 
	 * 是否可以传送进入副本
	 */
	private int carry;
	
	
	/**
	 * 触发副本关闭流程的条件
	 */
	private int closeid;
	
	
	/**
	 * 在副本结算时出现的奖励道具列表
	 */
	private int achieveprop;
	
	
	/**
	 * 进入该地图后能否组队 1=可以（默认） 2=不可以
	 */
	private int teamastrict;
	
	/**
	 * 副本道具限制 声明在副本中禁用的道具 (*,*)
	 */
	private int noprop;
	
	/**
	 * 回城限制 该地图中是否允许使用回城技能和道具 1=可以（默认） 2=不可以
	 */
	private int backCity;
	/**
	 * 路点记录限制 该地图中是否允许使用路点记录道具 1=可以（默认） 2=不可以
	 */
	private int annal;
	/**
	 * 该地图当中是否允许玩家之间进行交易 1=可以（默认） 2=不可以
	 */
	private int bargain;
	/**
	 * 该地图当中是否允许玩家之间进行决斗 1=可以（默认） 2=不可以
	 */
	private int duel;
	/**
	 * 该地图当中是否允许使用自动寻路功能 1=可以（默认） 2=不可以
	 */
	private int autoway;
	/**
	 * 玩家进入副本时所在的初始场景的ID
	 */
	private int insceneid;
	/**
	 * 玩家从副本登出后到达的地图的ID
	 */
	private int outsceneid;
	
	/**
	 * 激活副本的条件Id
	 */
	private int activateid;
	
	/**
	 * 副本建议人数
	 */
	private int numbers;
	
	/**
	 * 副本掉落主键id
	 */
	private int dropoutid;
	
	/**
	 * 副本所在区域的场景id
	 */
	private int areasceneid;

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

	public int getHard() {
		return hard;
	}

	public void setHard(int hard) {
		this.hard = hard;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public Date getStartime() {
		return startime;
	}

	public void setStartime(Date startime) {
		this.startime = startime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public int getUpLevle() {
		return upLevle;
	}

	public void setUpLevle(int upLevle) {
		this.upLevle = upLevle;
	}

	public int getDownLevle() {
		return downLevle;
	}

	public void setDownLevle(int downLevle) {
		this.downLevle = downLevle;
	}

	public int getProps() {
		return props;
	}

	public void setProps(int props) {
		this.props = props;
	}

	public int getGuildLevel() {
		return guildLevel;
	}

	public void setGuildLevel(int guildLevel) {
		this.guildLevel = guildLevel;
	}

	public int getPknum() {
		return pknum;
	}

	public void setPknum(int pknum) {
		this.pknum = pknum;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getTeamState() {
		return teamState;
	}

	public void setTeamState(int teamState) {
		this.teamState = teamState;
	}

	public int getTeammax() {
		return teammax;
	}

	public void setTeammax(int teammax) {
		this.teammax = teammax;
	}

	public int getTeammin() {
		return teammin;
	}

	public void setTeammin(int teammin) {
		this.teammin = teammin;
	}

	public int getCarry() {
		return carry;
	}

	public void setCarry(int carry) {
		this.carry = carry;
	}

	public int getCloseid() {
		return closeid;
	}

	public void setCloseid(int closeid) {
		this.closeid = closeid;
	}

	public int getAchieveprop() {
		return achieveprop;
	}

	public void setAchieveprop(int achieveprop) {
		this.achieveprop = achieveprop;
	}

	public int getTeamastrict() {
		return teamastrict;
	}

	public void setTeamastrict(int teamastrict) {
		this.teamastrict = teamastrict;
	}

	public int getNoprop() {
		return noprop;
	}

	public void setNoprop(int noprop) {
		this.noprop = noprop;
	}

	public int getBackCity() {
		return backCity;
	}

	public void setBackCity(int backCity) {
		this.backCity = backCity;
	}

	public int getAnnal() {
		return annal;
	}

	public void setAnnal(int annal) {
		this.annal = annal;
	}

	public int getBargain() {
		return bargain;
	}

	public void setBargain(int bargain) {
		this.bargain = bargain;
	}

	public int getDuel() {
		return duel;
	}

	public void setDuel(int duel) {
		this.duel = duel;
	}

	public int getAutoway() {
		return autoway;
	}

	public void setAutoway(int autoway) {
		this.autoway = autoway;
	}

	public int getInsceneid() {
		return insceneid;
	}

	public void setInsceneid(int insceneid) {
		this.insceneid = insceneid;
	}

	public int getOutsceneid() {
		return outsceneid;
	}

	public void setOutsceneid(int outsceneid) {
		this.outsceneid = outsceneid;
	}

	public int getActivateid() {
		return activateid;
	}

	public void setActivateid(int activateid) {
		this.activateid = activateid;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public int getDropoutid() {
		return dropoutid;
	}

	public void setDropoutid(int dropoutid) {
		this.dropoutid = dropoutid;
	}

	public int getAreasceneid() {
		return areasceneid;
	}

	public void setAreasceneid(int areasceneid) {
		this.areasceneid = areasceneid;
	}
	
}
