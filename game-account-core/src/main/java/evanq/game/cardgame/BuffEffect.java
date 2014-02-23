package evanq.game.cardgame;

/**
 * 
 * 进入buff后，产生的效果
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class BuffEffect {

	
	private int buffEffectID;
	
	
	/**
	 * buff属性 1物理 2魔法
	 */
	private int attributeType;
	
	
	/**
	 * buff触发条件
	 */
	private String effectTriggerCondition;
	
	
	/**
	 * 被动触发的buff或debuff效果计算公式
	 */
	private String triggerEffectFormula;
	
	
	/**
	 * 被动触发的Dot或hot效果计算公式
	 */
	private String triggerDotHotFormula;
	
	
	/**
	 * buff或debuff的效果计算公式
	 */
	private String effectFormula;
	
	
	/**
	 * Dot或hot效果公式
	 */
	private String dotHotFormula;
	
	
	/**
	 * 技能消失时的效果（技能效果添加的逆运算）
	 */
	private String effectDropFormula;
	
	
	private int addBuffId;


	public int getBuffEffectID() {
		return buffEffectID;
	}


	public void setBuffEffectID(int buffEffectID) {
		this.buffEffectID = buffEffectID;
	}


	public int getAttributeType() {
		return attributeType;
	}


	public void setAttributeType(int attributeType) {
		this.attributeType = attributeType;
	}


	public String getEffectTriggerCondition() {
		return effectTriggerCondition;
	}


	public void setEffectTriggerCondition(String effectTriggerCondition) {
		this.effectTriggerCondition = effectTriggerCondition;
	}


	public String getTriggerEffectFormula() {
		return triggerEffectFormula;
	}


	public void setTriggerEffectFormula(String triggerEffectFormula) {
		this.triggerEffectFormula = triggerEffectFormula;
	}


	public String getTriggerDotHotFormula() {
		return triggerDotHotFormula;
	}


	public void setTriggerDotHotFormula(String triggerDotHotFormula) {
		this.triggerDotHotFormula = triggerDotHotFormula;
	}


	public String getEffectFormula() {
		return effectFormula;
	}


	public void setEffectFormula(String effectFormula) {
		this.effectFormula = effectFormula;
	}


	public String getDotHotFormula() {
		return dotHotFormula;
	}


	public void setDotHotFormula(String dotHotFormula) {
		this.dotHotFormula = dotHotFormula;
	}


	public String getEffectDropFormula() {
		return effectDropFormula;
	}


	public void setEffectDropFormula(String effectDropFormula) {
		this.effectDropFormula = effectDropFormula;
	}


	public int getAddBuffId() {
		return addBuffId;
	}


	public void setAddBuffId(int addBuffId) {
		this.addBuffId = addBuffId;
	}

}
