package evanq.game.cardgame.domain.model.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 账号的角色列表
 * 
 * @author Evan cppmain@gmail.com
 *
 */
@Entity
@Table(name="role_list")
public class RoleList {
	
	@Id
	@Column(name="actId")

	private int actId;
	
	@Column
	private int roleId_1;
	@Column
	private int roleId_2;
	@Column
	private int roleId_3;
	@Column
	private int roleId_4;
	@Column
	private int roleId_5;
	
	@Column
	private int lastLoginRoleId;
	
	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
		this.actId = actId;
	}

	public int getRoleId_1() {
		return roleId_1;
	}

	public void setRoleId_1(int roleId_1) {
		this.roleId_1 = roleId_1;
	}

	public int getRoleId_2() {
		return roleId_2;
	}

	public void setRoleId_2(int roleId_2) {
		this.roleId_2 = roleId_2;
	}

	public int getRoleId_3() {
		return roleId_3;
	}

	public void setRoleId_3(int roleId_3) {
		this.roleId_3 = roleId_3;
	}

	public int getRoleId_4() {
		return roleId_4;
	}

	public void setRoleId_4(int roleId_4) {
		this.roleId_4 = roleId_4;
	}

	public int getRoleId_5() {
		return roleId_5;
	}

	public void setRoleId_5(int roleId_5) {
		this.roleId_5 = roleId_5;
	}

	public int getLastLoginRoleId() {
		return lastLoginRoleId;
	}

	public void setLastLoginRoleId(int lastLoginRoleId) {
		this.lastLoginRoleId = lastLoginRoleId;
	}
	
	
}
