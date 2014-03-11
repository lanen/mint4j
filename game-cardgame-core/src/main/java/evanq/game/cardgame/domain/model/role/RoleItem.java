package evanq.game.cardgame.domain.model.role;

import java.util.Date;

/**
 * 可穿戴的物品，不支持叠加
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RoleItem {
	
	private int id;
	
	private int roleId;
	
	/**
	 * 物品管理： 1 装备，2道具，3 仓库 4,快捷栏 5，寄售 6，快递中。。。
	 */
	private int tag;
	
	private int position;
	
	private boolean isBinding;
	
	/**
	 * 是否鉴定
	 */
	private byte isIdentified;
	
	/**
	 * 叠加数 (1-99)
	 */
	private int overlay;
	
	/**
	 * 强化等级
	 */
	private byte strengthen;
	
	/**
	 * 当前持久度
	 */
	private int durability;
	
	/**
	 * 冷却时间开始
	 */
	private Date cdStartTime;
	
	/**
	 * 冷却时长
	 */
	private int cdCount;
	
	private int slot_1;
	
	private int slot_2;
	
	private int slot_3;
	
	private int slot_4;
	
	private int slot_5;

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

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isBinding() {
		return isBinding;
	}

	public void setBinding(boolean isBinding) {
		this.isBinding = isBinding;
	}

	public byte getIsIdentified() {
		return isIdentified;
	}

	public void setIsIdentified(byte isIdentified) {
		this.isIdentified = isIdentified;
	}

	public int getOverlay() {
		return overlay;
	}

	public void setOverlay(int overlay) {
		this.overlay = overlay;
	}

	public byte getStrengthen() {
		return strengthen;
	}

	public void setStrengthen(byte strengthen) {
		this.strengthen = strengthen;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public int getSlot_1() {
		return slot_1;
	}

	public void setSlot_1(int slot_1) {
		this.slot_1 = slot_1;
	}

	public int getSlot_2() {
		return slot_2;
	}

	public void setSlot_2(int slot_2) {
		this.slot_2 = slot_2;
	}

	public int getSlot_3() {
		return slot_3;
	}

	public void setSlot_3(int slot_3) {
		this.slot_3 = slot_3;
	}

	public int getSlot_4() {
		return slot_4;
	}

	public void setSlot_4(int slot_4) {
		this.slot_4 = slot_4;
	}

	public int getSlot_5() {
		return slot_5;
	}

	public void setSlot_5(int slot_5) {
		this.slot_5 = slot_5;
	}

	public Date getCdStartTime() {
		return cdStartTime;
	}

	public void setCdStartTime(Date cdStartTime) {
		this.cdStartTime = cdStartTime;
	}

	public int getCdCount() {
		return cdCount;
	}

	public void setCdCount(int cdCount) {
		this.cdCount = cdCount;
	}
	
}
