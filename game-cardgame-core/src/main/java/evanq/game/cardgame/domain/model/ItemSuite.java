package evanq.game.cardgame.domain.model;

public class ItemSuite {

	private int suiteId;
	
	private String name;
	
	private String description;
	
	private String effect;

	public int getSuiteId() {
		return suiteId;
	}

	public void setSuiteId(int suiteId) {
		this.suiteId = suiteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	
}
