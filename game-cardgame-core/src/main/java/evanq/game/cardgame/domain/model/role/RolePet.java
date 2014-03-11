package evanq.game.cardgame.domain.model.role;

/**
 * 
 * 角色的宠物
 * @author Evan cppmain@gmail.com
 *
 */
public class RolePet {

	private int id;
	
	private int roleId;
	
	private int petTemplateId;
	
	private int name;
	
	private int level;
	
	private int exp;
	
	private int hp;
	
	private int mp;
	
	/**
	 * 力量成长
	 */
	private int strGrowth;
	/**
	 * 智力成长
	 */
	private int wisGrowth;
	/**
	 * 耐力成长
	 */
	private int vitGrowth;
	/**
	 * 敏捷成长
	 */
	private int dexGrowth;

	private int showed;
	
	private int energy;

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

	public int getPetTemplateId() {
		return petTemplateId;
	}

	public void setPetTemplateId(int petTemplateId) {
		this.petTemplateId = petTemplateId;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getStrGrowth() {
		return strGrowth;
	}

	public void setStrGrowth(int strGrowth) {
		this.strGrowth = strGrowth;
	}

	public int getWisGrowth() {
		return wisGrowth;
	}

	public void setWisGrowth(int wisGrowth) {
		this.wisGrowth = wisGrowth;
	}

	public int getVitGrowth() {
		return vitGrowth;
	}

	public void setVitGrowth(int vitGrowth) {
		this.vitGrowth = vitGrowth;
	}

	public int getDexGrowth() {
		return dexGrowth;
	}

	public void setDexGrowth(int dexGrowth) {
		this.dexGrowth = dexGrowth;
	}

	public int getShowed() {
		return showed;
	}

	public void setShowed(int showed) {
		this.showed = showed;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
}
