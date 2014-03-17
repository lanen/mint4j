package evanq.game.cardgame.application;

public interface UCRoleQuest {

	
	/**
	 * 
	 * 接受任务
	 */
	public void acceptQuest();
	
	/**
	 * 
	 * 拒接任务
	 */
	public void denyQuest();
	
	/**
	 * 
	 * 列出我的任务
	 */
	public void myQuest();
	
	/**
	 * 获取奖励
	 */
	public void acceptQuestReward();
	
	/**
	 * 
	 * 完成任务
	 */
	public void finishQuest();
	
	/**
	 * 
	 * 任务失败
	 */
	public void failedQuest();
}
