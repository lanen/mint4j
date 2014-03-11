package evanq.game.cardgame.domain.model;

/**
 * 
 * Pet 成长模板
 * 
 * 根据宠物当前品质 @see {@link PetTemplate}.baseQuality，提升宠物的四属性
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class PetGrowthTemplate {

	private int id;
	
	/**
	 * 当前品质
	 */
	private int quality;
	
	/**
	 * 
	 */
	private int petType;
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getPetType() {
		return petType;
	}
	public void setPetType(int petType) {
		this.petType = petType;
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
}
