package evanq.game.cardgame;

/**
 * 
 * 任务模板
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class QuestTemplate {
	
	private int id;
	
	private String name;
	
	private String description;
	
	/**
	 * 在那个场景接任务
	 */
	private int sceneId;
	
	/**
	 * 任务类型 @see {@link QuestType}
	 */
	private int type;
	
	/**
	 * 任务目标 @see {@link QuestTarget}
	 */
	private int questTarget;
	
	
	/**
	 * 
	 * 职业限制
	 */
	private int professionRequire;
	
	/**
	 * 等级限制
	 */
	private int levelRequire;
	
	/**
	 * 行会等级限制
	 */
	private int guildLevelRequire;
	
	/**
	 * 必须完成前置任务，才能接受该任务
	 */
	private int taskBefore;
	
	/**
	 * 任务提供者
	 * @see {@link QuestProvider}  
	 */
	private int providerType;

	
	private int providerID;
		
	
	/**
	 * 获得任务的条件类型
	 */
	private int conditionType;
	
	/**
	 * 判断内容
	 */
	private int condition;
	

	//奖励内容{{{
	private int rewardItemID_1;
	private int rewardItemCount_1;
	private int rewardItemID_2;
	private int rewardItemCount_2;
	private int rewardItemID_3;
	private int rewardItemCount_3;
	
	
	private int coin;
	private int gold;
	private int prestige;
	private int exp;
	private String rewardScript;/** 如果奖励的内容和方式比较复杂，使用脚本处理 */

	//奖励内容}}}
	
	/**
	 * 任务完成的报告对象：
	 */
	private int reporterType;
	private int reporterID;	
	
	/**
	 * 
	 */
	private String questDialogue;
	
	private String questDenyDialogue;
	
	private String questAccepDialogue;
	
	/**
	 * 任务未完成时提供者的对话
	 */
	private String questConductDialogue_p;
	
	/**
	 * 任务未完成时提交者的对话
	 */
	private String questConductDialogue_r;
	
	private String questFinishDialogue;

	private int refreshTime;
	
	private int executableCount;
	
	private int visible;
	
	private int categories_id;
	
	private String targets;

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

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getQuestTarget() {
		return questTarget;
	}

	public void setQuestTarget(int questTarget) {
		this.questTarget = questTarget;
	}

	public int getProfessionRequire() {
		return professionRequire;
	}

	public void setProfessionRequire(int professionRequire) {
		this.professionRequire = professionRequire;
	}

	public int getLevelRequire() {
		return levelRequire;
	}

	public void setLevelRequire(int levelRequire) {
		this.levelRequire = levelRequire;
	}

	public int getGuildLevelRequire() {
		return guildLevelRequire;
	}

	public void setGuildLevelRequire(int guildLevelRequire) {
		this.guildLevelRequire = guildLevelRequire;
	}

	public int getTaskBefore() {
		return taskBefore;
	}

	public void setTaskBefore(int taskBefore) {
		this.taskBefore = taskBefore;
	}

	public int getProviderType() {
		return providerType;
	}

	public void setProviderType(int providerType) {
		this.providerType = providerType;
	}

	public int getProviderID() {
		return providerID;
	}

	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}

	public int getConditionType() {
		return conditionType;
	}

	public void setConditionType(int conditionType) {
		this.conditionType = conditionType;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public int getRewardItemID_1() {
		return rewardItemID_1;
	}

	public void setRewardItemID_1(int rewardItemID_1) {
		this.rewardItemID_1 = rewardItemID_1;
	}

	public int getRewardItemCount_1() {
		return rewardItemCount_1;
	}

	public void setRewardItemCount_1(int rewardItemCount_1) {
		this.rewardItemCount_1 = rewardItemCount_1;
	}

	public int getRewardItemID_2() {
		return rewardItemID_2;
	}

	public void setRewardItemID_2(int rewardItemID_2) {
		this.rewardItemID_2 = rewardItemID_2;
	}

	public int getRewardItemCount_2() {
		return rewardItemCount_2;
	}

	public void setRewardItemCount_2(int rewardItemCount_2) {
		this.rewardItemCount_2 = rewardItemCount_2;
	}

	public int getRewardItemID_3() {
		return rewardItemID_3;
	}

	public void setRewardItemID_3(int rewardItemID_3) {
		this.rewardItemID_3 = rewardItemID_3;
	}

	public int getRewardItemCount_3() {
		return rewardItemCount_3;
	}

	public void setRewardItemCount_3(int rewardItemCount_3) {
		this.rewardItemCount_3 = rewardItemCount_3;
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

	public int getPrestige() {
		return prestige;
	}

	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getRewardScript() {
		return rewardScript;
	}

	public void setRewardScript(String rewardScript) {
		this.rewardScript = rewardScript;
	}

	public int getReporterType() {
		return reporterType;
	}

	public void setReporterType(int reporterType) {
		this.reporterType = reporterType;
	}

	public int getReporterID() {
		return reporterID;
	}

	public void setReporterID(int reporterID) {
		this.reporterID = reporterID;
	}

	public String getQuestDialogue() {
		return questDialogue;
	}

	public void setQuestDialogue(String questDialogue) {
		this.questDialogue = questDialogue;
	}

	public String getQuestDenyDialogue() {
		return questDenyDialogue;
	}

	public void setQuestDenyDialogue(String questDenyDialogue) {
		this.questDenyDialogue = questDenyDialogue;
	}

	public String getQuestAccepDialogue() {
		return questAccepDialogue;
	}

	public void setQuestAccepDialogue(String questAccepDialogue) {
		this.questAccepDialogue = questAccepDialogue;
	}

	public String getQuestConductDialogue_p() {
		return questConductDialogue_p;
	}

	public void setQuestConductDialogue_p(String questConductDialogue_p) {
		this.questConductDialogue_p = questConductDialogue_p;
	}

	public String getQuestConductDialogue_r() {
		return questConductDialogue_r;
	}

	public void setQuestConductDialogue_r(String questConductDialogue_r) {
		this.questConductDialogue_r = questConductDialogue_r;
	}

	public String getQuestFinishDialogue() {
		return questFinishDialogue;
	}

	public void setQuestFinishDialogue(String questFinishDialogue) {
		this.questFinishDialogue = questFinishDialogue;
	}

	public int getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(int refreshTime) {
		this.refreshTime = refreshTime;
	}

	public int getExecutableCount() {
		return executableCount;
	}

	public void setExecutableCount(int executableCount) {
		this.executableCount = executableCount;
	}

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}

	public int getCategories_id() {
		return categories_id;
	}

	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}

	public String getTargets() {
		return targets;
	}

	public void setTargets(String targets) {
		this.targets = targets;
	}
	
}
