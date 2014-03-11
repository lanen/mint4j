package evanq.game.cardgame.domain.model;

public class BuffBuff {

	private int id;
	
	private int buffId;
	
	private int requireBuffId;
	
	private int produceBuffId;
	
	private int nstack;
	
	private String effect;

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

	public int getRequireBuffId() {
		return requireBuffId;
	}

	public void setRequireBuffId(int requireBuffId) {
		this.requireBuffId = requireBuffId;
	}

	public int getProduceBuffId() {
		return produceBuffId;
	}

	public void setProduceBuffId(int produceBuffId) {
		this.produceBuffId = produceBuffId;
	}

	public int getNstack() {
		return nstack;
	}

	public void setNstack(int nstack) {
		this.nstack = nstack;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	

}
