package evanq.game.cardgame.role;

import java.util.Date;

/**
 * 
 * 角色身上的效果
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RoleEffectList {

	private int id;
	
	private int roleId;
	
	private int effectId;
	
	/**
	 * 开始时间
	 */
	private Date startTime;
	
	/**
	 * 剩余时间
	 */
	private int duration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getEffectId() {
		return effectId;
	}

	public void setEffectId(int effectId) {
		this.effectId = effectId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
