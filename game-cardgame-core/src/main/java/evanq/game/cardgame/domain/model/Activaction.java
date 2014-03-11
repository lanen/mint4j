package evanq.game.cardgame.domain.model;

/**
 * 
 * 激活记录
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class Activaction {

	private int id;
	
	private String activeCode;
	
	private long userGuid;
	
	private int roleId;
	
	private ActivactionType activeType;
	
	private ActivactionState activeState;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public long getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(long userGuid) {
		this.userGuid = userGuid;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public ActivactionType getActiveType() {
		return activeType;
	}

	public void setActiveType(ActivactionType activeType) {
		this.activeType = activeType;
	}

	public ActivactionState getActiveState() {
		return activeState;
	}

	public void setActiveState(ActivactionState activeState) {
		this.activeState = activeState;
	}
}
