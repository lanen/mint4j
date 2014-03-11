package evanq.game.cardgame.domain.model;

/**
 * 
 * 描述 buff,debuff,hot,dot
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class BuffInfo {
	/**
	 * buff的ID
	 */
	private int buffId;
	/**
	 * buff的名称
	 */
	private String buffName;
	/**
	 * buff的描述
	 */
	private String buffDesc;
	
	/**
	 * buff的持续回合数
	 */
	private int traceCD;
	/**
	 * 可替换的buff的id
	 */
	private int replaceBuff;
	
	/**
	 * buff的类型
	 */
	private int buffType;
	
	/**
	 * buff的最大堆叠层数
	 */
	private int maxStack;
	
	/**
	 * buff的效果的id
	 */
	private int buffEffectID;
	
	/**
	 * buff的资源id
	 */
	private int buffEffectResource;
	
	/**
	 * buff的图标ID
	 */
	private int icon;

	public int getBuffId() {
		return buffId;
	}

	public void setBuffId(int buffId) {
		this.buffId = buffId;
	}

	public String getBuffName() {
		return buffName;
	}

	public void setBuffName(String buffName) {
		this.buffName = buffName;
	}

	public String getBuffDesc() {
		return buffDesc;
	}

	public void setBuffDesc(String buffDesc) {
		this.buffDesc = buffDesc;
	}

	public int getTraceCD() {
		return traceCD;
	}

	public void setTraceCD(int traceCD) {
		this.traceCD = traceCD;
	}

	public int getReplaceBuff() {
		return replaceBuff;
	}

	public void setReplaceBuff(int replaceBuff) {
		this.replaceBuff = replaceBuff;
	}

	public int getBuffType() {
		return buffType;
	}

	public void setBuffType(int buffType) {
		this.buffType = buffType;
	}

	public int getMaxStack() {
		return maxStack;
	}

	public void setMaxStack(int maxStack) {
		this.maxStack = maxStack;
	}

	public int getBuffEffectID() {
		return buffEffectID;
	}

	public void setBuffEffectID(int buffEffectID) {
		this.buffEffectID = buffEffectID;
	}

	public int getBuffEffectResource() {
		return buffEffectResource;
	}

	public void setBuffEffectResource(int buffEffectResource) {
		this.buffEffectResource = buffEffectResource;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}
	
}
