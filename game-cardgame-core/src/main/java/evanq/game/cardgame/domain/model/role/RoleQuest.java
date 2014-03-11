package evanq.game.cardgame.domain.model.role;

import java.util.Date;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RoleQuest {
	
	private int id;
	
	private int roleId;
	
	/**
	 * 任务步骤
	 */
	private int step;
	
	/**
	 * 接受时间
	 */
	private Date applyTime;
	
	/**
	 * 完成时间
	 */
	private Date finishTime;
	
	private int status;
	
	private int trackStatu;
	
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
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTrackStatu() {
		return trackStatu;
	}
	public void setTrackStatu(int trackStatu) {
		this.trackStatu = trackStatu;
	}
	
	
	

}
