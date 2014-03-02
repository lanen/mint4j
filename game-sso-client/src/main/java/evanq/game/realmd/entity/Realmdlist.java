package evanq.game.realmd.entity;

import java.io.Serializable;

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
/*@DiscriminatorColumn(name="flag",
	discriminatorType=DiscriminatorType.INTEGER,	
	columnDefinition="TINYINT(1) DEFAULT 1")*/
@Table(name="realmdlist")
public class Realmdlist implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4202963988010495231L;

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private int gameId;
	
	@Column
	private String name;

	/**
	 * gateway服务器
	 */
	@Column
	private String address;
	
	@Column
	private int port;
	
	@Column
	private int icon;
	
	@Column
	private int realmflags;
	
	@Column
	private int locale;
	
	@Column
	private int timezone;
	
	@Column
	private int allowedSecurityLevel;
	
	@Column
	private int population;
	
	@Column
	private int realmbuilds;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public int getRealmflags() {
		return realmflags;
	}
	public void setRealmflags(int realmflags) {
		this.realmflags = realmflags;
	}
	public int getTimezone() {
		return timezone;
	}
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}
	public int getAllowedSecurityLevel() {
		return allowedSecurityLevel;
	}
	public void setAllowedSecurityLevel(int allowedSecurityLevel) {
		this.allowedSecurityLevel = allowedSecurityLevel;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getRealmbuilds() {
		return realmbuilds;
	}
	public void setRealmbuilds(int realmbuilds) {
		this.realmbuilds = realmbuilds;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getLocale() {
		return locale;
	}
	public void setLocale(int locale) {
		this.locale = locale;
	}
	
}
