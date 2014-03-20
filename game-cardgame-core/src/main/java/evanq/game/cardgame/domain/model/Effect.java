package evanq.game.cardgame.domain.model;

/**
 * 技能、物品的效果，
 * 使用传送技能，从这个表中读取传送的特效，传送的脚本
 * @author Evan cppmain@gmail.com
 *
 */
public class Effect {

	private int id;
	
	private String name;
	private String description;
	
	/**
	 * 资源icon
	 */
	private int icon;
	
	/** 决定资源路径 */
	private int iconType;
	
	
	/**
	 * 效果是针对：无任何效果，血蓝，能量，经验，属性，触发buff或hot，传送，召唤
	 */
	private int effectType;

	
	/**
	 * 效果存活 类型: 时间，次数
	 */
	private int intervalType;
	
	/**
	 * 存活时间
	 */
	private int deadline;
	
	/**
	 * 存活次数
	 */
	private int allCount;

	/**
	 * 间隔时间
	 */
	private int intervalTime;
	
	/**
	 * 开始摇动时间
	 */
	private int shakeDeadline;
	
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

	public int getIntervalType() {
		return intervalType;
	}

	public void setIntervalType(int intervalType) {
		this.intervalType = intervalType;
	}

	
	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public int getShakeDeadline() {
		return shakeDeadline;
	}

	public void setShakeDeadline(int shakeDeadline) {
		this.shakeDeadline = shakeDeadline;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public int getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(int intervalTime) {
		this.intervalTime = intervalTime;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}
	
}
