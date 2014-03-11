package evanq.game.cardgame.domain.model.role;

/**
 * 
 * 新手引导奖励
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RoleGuideReward {

	/**
	 * 新手引导步骤
	 */
	private int step;
	
	/**
	 * 物品
	 */
	private int item;
	
	/**
	 * 物品数量
	 */
	private int itemStack;
	
	/**
	 * 金币
	 */
	private int coin;
	
	/**
	 * 充值币
	 */
	private int gold;
	
	/**
	 * 能量
	 */
	private int energy;
	
	/**
	 * 描述
	 */
	private String description;

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getItemStack() {
		return itemStack;
	}

	public void setItemStack(int itemStack) {
		this.itemStack = itemStack;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
