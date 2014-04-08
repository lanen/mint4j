package evanq.game.infrastructure.config;

public interface IConfigContext {

	public int get(String key, int defaultValue);
	
	public void relead();
}
