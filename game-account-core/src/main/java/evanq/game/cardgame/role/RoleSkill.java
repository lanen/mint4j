package evanq.game.cardgame.role;

/**
 * 
 * 角色技能列表
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RoleSkill {

	private int id;
	
	private int roleId;
	
	private int skillId;
	
	private int skillLevel;

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

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}
}
