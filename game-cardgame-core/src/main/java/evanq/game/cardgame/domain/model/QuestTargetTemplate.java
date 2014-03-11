package evanq.game.cardgame.domain.model;

/**
 * 
 * 任务执行步骤的内容
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class QuestTargetTemplate {
		
	private int id;
	
	private String description;
	
	
	/**
	 * 任务目标 @see {@link QuestTarget}
	 */
	private int questTarget;

	private int npcID;
	
	private int talkNum;
	
	private int goalMonsterID;
	
	private int killNum;
	
	private int useItemID;
	
	private int useNum;
	
	private int collectItemID;
	
	private int dropMonsterID;
	
	private int collectNum;
	
	private int equipmentID;
	
	private int goalQualityLevel;
	
	private int categories_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuestTarget() {
		return questTarget;
	}

	public void setQuestTarget(int questTarget) {
		this.questTarget = questTarget;
	}

	public int getNpcID() {
		return npcID;
	}

	public void setNpcID(int npcID) {
		this.npcID = npcID;
	}

	public int getTalkNum() {
		return talkNum;
	}

	public void setTalkNum(int talkNum) {
		this.talkNum = talkNum;
	}

	public int getGoalMonsterID() {
		return goalMonsterID;
	}

	public void setGoalMonsterID(int goalMonsterID) {
		this.goalMonsterID = goalMonsterID;
	}

	public int getKillNum() {
		return killNum;
	}

	public void setKillNum(int killNum) {
		this.killNum = killNum;
	}

	public int getUseItemID() {
		return useItemID;
	}

	public void setUseItemID(int useItemID) {
		this.useItemID = useItemID;
	}

	public int getUseNum() {
		return useNum;
	}

	public void setUseNum(int useNum) {
		this.useNum = useNum;
	}

	public int getCollectItemID() {
		return collectItemID;
	}

	public void setCollectItemID(int collectItemID) {
		this.collectItemID = collectItemID;
	}

	public int getDropMonsterID() {
		return dropMonsterID;
	}

	public void setDropMonsterID(int dropMonsterID) {
		this.dropMonsterID = dropMonsterID;
	}

	public int getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(int collectNum) {
		this.collectNum = collectNum;
	}

	public int getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(int equipmentID) {
		this.equipmentID = equipmentID;
	}

	public int getGoalQualityLevel() {
		return goalQualityLevel;
	}

	public void setGoalQualityLevel(int goalQualityLevel) {
		this.goalQualityLevel = goalQualityLevel;
	}

	public int getCategories_id() {
		return categories_id;
	}

	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}
	

}
