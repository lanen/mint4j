package evanq.game.cardgame.domain.model;

/**
 * 
 * 场景
 * @author Evan cppmain@gmail.com
 *
 */
public class Scene {

	private int id;
	
	private String name;
	private String description;
	
	
	/**
	 * 
	 */
	private int iconType;
	
	private int icon;
	
	/**
	 * 
	 * 地图
	 */
	private int mapId;
	
	
	/**
	 * 
	 */
	private int sceneType;

	/**
	 * 
	 * 场景状态
	 */
	private int sceneState;
	
	/**
	 * 进入场景时候触发的脚本
	 */
	private String enterScript;
	
	/**
	 *（角色） 离开场景触发的脚本
	 */
	private String leaveScript;
	
	
	/**
	 * 
	 * 在场景处于关闭状态时候，角色转移到指定场景（副本场景关闭了,转移脚本）
	 */
	private String tranformScript;
	
	
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

	public int getIconType() {
		return iconType;
	}

	public void setIconType(int iconType) {
		this.iconType = iconType;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public int getSceneType() {
		return sceneType;
	}

	public void setSceneType(int sceneType) {
		this.sceneType = sceneType;
	}

	public int getSceneState() {
		return sceneState;
	}

	public void setSceneState(int sceneState) {
		this.sceneState = sceneState;
	}

	public String getEnterScript() {
		return enterScript;
	}

	public void setEnterScript(String enterScript) {
		this.enterScript = enterScript;
	}

	public String getLeaveScript() {
		return leaveScript;
	}

	public void setLeaveScript(String leaveScript) {
		this.leaveScript = leaveScript;
	}

	public String getTranformScript() {
		return tranformScript;
	}

	public void setTranformScript(String tranformScript) {
		this.tranformScript = tranformScript;
	}
}
