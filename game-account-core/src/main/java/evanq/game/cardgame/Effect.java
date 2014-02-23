package evanq.game.cardgame;

/**
 * 技能、物品的效果
 * @author Evan cppmain@gmail.com
 *
 */
public class Effect {

	private int id;
	
	private String name;
	private String description;
	
	private int icon;
	private int iconType;
	
	
	/**
	 * 效果是针对：血蓝，能量，经验，属性，触发buff或hot，
	 */
	private int effectType;
	
	/**
	 * buff与debuf = 1; hot 与 dot =2;
	 * 
	 * 这两者1 影响属性；2影响血量
	 */
	private int triggerType;
	
	
	/**
	 * 效果存活 类型
	 */
	private int lifeType;
	/**
	 * 存活时间
	 */
	private int lifeTime;
	/**
	 * 存活次数
	 */
	private int lifeCount;

	private String script;

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

	public int getEffectType() {
		return effectType;
	}

	public void setEffectType(int effectType) {
		this.effectType = effectType;
	}

	public int getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(int triggerType) {
		this.triggerType = triggerType;
	}

	public int getLifeType() {
		return lifeType;
	}

	public void setLifeType(int lifeType) {
		this.lifeType = lifeType;
	}

	public int getLifeTime() {
		return lifeTime;
	}

	public void setLifeTime(int lifeTime) {
		this.lifeTime = lifeTime;
	}

	public int getLifeCount() {
		return lifeCount;
	}

	public void setLifeCount(int lifeCount) {
		this.lifeCount = lifeCount;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}
	
	
}
