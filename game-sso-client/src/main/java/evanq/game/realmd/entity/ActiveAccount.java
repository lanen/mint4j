package evanq.game.realmd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="active_account")
public class ActiveAccount {
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String account;
	
	@Column
	private long sessionKey;
	
	/**
	 * 账号类型：普通用户，游戏管理员
	 */
	@Column
	private int accountType;
	
	@Column
	private String lastIp;
	
	@Column
	private int activeRealmd;
	
	@Column
	private Date lastLoginTime;
	
	@Column
	private int locale;
	
	@Column
	private int locked;
	
	@Column
	private Date unlockTime;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public long getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(long sessionKey) {
		this.sessionKey = sessionKey;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public int getActiveRealmd() {
		return activeRealmd;
	}

	public void setActiveRealmd(int activeRealmd) {
		this.activeRealmd = activeRealmd;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getLocale() {
		return locale;
	}

	public void setLocale(int locale) {
		this.locale = locale;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public Date getUnlockTime() {
		return unlockTime;
	}

	public void setUnlockTime(Date unlockTime) {
		this.unlockTime = unlockTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
