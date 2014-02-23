package evanq.game.cardgame;

/**
 * 
 * 物品合成
 * @author Evan cppmain@gmail.com
 *
 */
public class ItemCompound {

	private int id;
	
	/**
	 * 合成物品编号
	 */
	private int item;
	
	/**
	 * 配方名称
	 */
	private String name;
	
	/**
	 * 合成的物品类型
	 */
	private int type; 
	
	/**
	 * 所需金钱
	 */
	private int coin;
	
	/**
	 * 合成等级
	 */
	private int level;
	
	private int needItem_1;
	private int needCount_1;
	
	private int needItem_2;	
	private int needCount_2;
	
	private int needItem_3;
	
	private int needCount_3;
	
	
	private int needItem_4;
	
	private int needCount_4;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNeedItem_1() {
		return needItem_1;
	}

	public void setNeedItem_1(int needItem_1) {
		this.needItem_1 = needItem_1;
	}

	public int getNeedCount_1() {
		return needCount_1;
	}

	public void setNeedCount_1(int needCount_1) {
		this.needCount_1 = needCount_1;
	}

	public int getNeedItem_2() {
		return needItem_2;
	}

	public void setNeedItem_2(int needItem_2) {
		this.needItem_2 = needItem_2;
	}

	public int getNeedCount_2() {
		return needCount_2;
	}

	public void setNeedCount_2(int needCount_2) {
		this.needCount_2 = needCount_2;
	}

	public int getNeedItem_3() {
		return needItem_3;
	}

	public void setNeedItem_3(int needItem_3) {
		this.needItem_3 = needItem_3;
	}

	public int getNeedCount_3() {
		return needCount_3;
	}

	public void setNeedCount_3(int needCount_3) {
		this.needCount_3 = needCount_3;
	}

	public int getNeedItem_4() {
		return needItem_4;
	}

	public void setNeedItem_4(int needItem_4) {
		this.needItem_4 = needItem_4;
	}

	public int getNeedCount_4() {
		return needCount_4;
	}

	public void setNeedCount_4(int needCount_4) {
		this.needCount_4 = needCount_4;
	}
}
