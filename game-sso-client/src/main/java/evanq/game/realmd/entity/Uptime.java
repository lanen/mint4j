package evanq.game.realmd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="uptime")
public class Uptime {

	@Id
	@Column
	private int realmdId;
	
	/**
	 * 开始时间 
	 */
	@Column
	private Date startTime;
	
	@Column
	private Date uptime;
	
	@Column
	private String startMessage;
	
	@Column
	private int maxPlayers;

	public int getRealmdId() {
		return realmdId;
	}

	public void setRealmdId(int realmdId) {
		this.realmdId = realmdId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getUptime() {
		return uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	public String getStartMessage() {
		return startMessage;
	}

	public void setStartMessage(String startMessage) {
		this.startMessage = startMessage;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	
	
}
