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
	
	private int type;
	
	private int resourceId;
	
	private int portalX;
	
	private int protalY;
	
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
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getResourceId() {
		return resourceId;
		
	}
	
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	
	public int getPortalX() {
		return portalX;
	}
	
	public void setPortalX(int portalX) {
		this.portalX = portalX;
	}
	
	public int getProtalY() {
		return protalY;
	}
	
	public void setProtalY(int protalY) {
		this.protalY = protalY;
	}
	
}
