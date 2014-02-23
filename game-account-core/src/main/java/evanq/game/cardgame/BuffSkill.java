package evanq.game.cardgame;

/**
 * 
 * buff 对技能的 增益，减益
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class BuffSkill {

	private int id;
	
	private int buffId;
	
	private int skillId;
	
	private int addition;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuffId() {
		return buffId;
	}

	public void setBuffId(int buffId) {
		this.buffId = buffId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getAddition() {
		return addition;
	}

	public void setAddition(int addition) {
		this.addition = addition;
	}

}
