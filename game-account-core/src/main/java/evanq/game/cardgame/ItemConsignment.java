package evanq.game.cardgame;

import java.util.Date;

/**
 * 
 * 物品托买
 * 
 * 需要提供物品或者宠物更多的东西。第一迭代不要求加，就默认是托管物品
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ItemConsignment {

	private int id;
	
	private int roleId;
	
	private int itemId;
	
	private int stack;
	
	/**
	 * 价格
	 */
	private int price;
	/**
	 * 钱的类型
	 */
	private int priceType;

	/**
	 * 托管时间
	 */
	private Date addTime;
	
	/**
	 * 多长时间
	 */
	private int howlong;

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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getStack() {
		return stack;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPriceType() {
		return priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public int getHowlong() {
		return howlong;
	}

	public void setHowlong(int howlong) {
		this.howlong = howlong;
	}
	
	
}

