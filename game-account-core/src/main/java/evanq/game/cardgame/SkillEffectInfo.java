package evanq.game.cardgame;

/**
 * 
 * 技能效果
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class SkillEffectInfo {

	/**
	 * 技能特效ID
	 */
	private int effectId;
	
	/**
	 * 技能计算公式
	 */
	private String formula;
	
	/**
	 * 清除BUFF的ID
	 */
	private int clearBuffId;
	
	/**
	 * 清除BUFF的概率
	 */
	private int clearRate;
	
	/**
	 * 添加BUFF 的ID
	 */
	private int addBuffId;
	
	/**
	 * 添加BUFF的概率
	 */
	private int addRate;

	public int getEffectId() {
		return effectId;
	}

	public void setEffectId(int effectId) {
		this.effectId = effectId;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public int getClearBuffId() {
		return clearBuffId;
	}

	public void setClearBuffId(int clearBuffId) {
		this.clearBuffId = clearBuffId;
	}

	public int getClearRate() {
		return clearRate;
	}

	public void setClearRate(int clearRate) {
		this.clearRate = clearRate;
	}

	public int getAddBuffId() {
		return addBuffId;
	}

	public void setAddBuffId(int addBuffId) {
		this.addBuffId = addBuffId;
	}

	public int getAddRate() {
		return addRate;
	}

	public void setAddRate(int addRate) {
		this.addRate = addRate;
	}
	
	
}
