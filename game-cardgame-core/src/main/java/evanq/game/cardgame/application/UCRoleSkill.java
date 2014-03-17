package evanq.game.cardgame.application;

/**
 * 角色技能用例
 * @author Evan cppmain@gmail.com
 *
 */
public interface UCRoleSkill {

	/**
	 * 学习技能
	 */
	public void learnSkill();
	
	/**
	 * 升级技能
	 */
	public void upgradeSkill();
	
	/**
	 * 遗忘技能
	 */
	public void forgotSkill();
	
	/**
	 * 释放技能
	 */
	public void castSkill();

	/**
	 * 我的技能
	 */
	public void mySkillEffect();
	
	/**
	 * 开始隐藏
	 */
	public void startSpell();
	
	/**
	 * 取消吟唱
	 */
	public void stopSpell();
	
	/**
	 * 吟唱被打断
	 */
	public void beBrokenSpelling(); 
}
