package evanq.game.cardgame;

/**
 * 
 * 场景 传送点，门
 * @author Evan cppmain@gmail.com
 *
 */
public class ScenePortal {

	private int id;
	private String name;
	private String description;
	
	private int resourceId;
	
	private int portalType;
	
	private int levelRequired;
	
	/**
	 * 目标场景
	 */
	private int sceneId;

	/**
	 * 传送时候的脚本
	 * 
	 */
	private String portalScript;
	
	/**
	 * 
	 */
	private int position_x;
	
	/**
	 * 
	 */
	private int position_y;

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

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getPortalType() {
		return portalType;
	}

	public void setPortalType(int portalType) {
		this.portalType = portalType;
	}

	public int getLevelRequired() {
		return levelRequired;
	}

	public void setLevelRequired(int levelRequired) {
		this.levelRequired = levelRequired;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public String getPortalScript() {
		return portalScript;
	}

	public void setPortalScript(String portalScript) {
		this.portalScript = portalScript;
	}

	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	
}
