package evanq.game.cardgame.domain.model;

/**
 * 
 * 来自账号服务器的激活
 * 
 * @author Evan
 *
 */
public class ActiveRegister {
	
	private int id;
	
	/** 全局唯一ID,合区时候标记 */
	private long guid;
	
	private String uername;
	
	private String password;
	
	//记录默认角色
	private int roleId;
	
	private int state;

	public String getUername() {
		return uername;
	}

	public void setUername(String uername) {
		this.uername = uername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getGuid() {
		return guid;
	}

	public void setGuid(long guid) {
		this.guid = guid;
	}
	
	
}
