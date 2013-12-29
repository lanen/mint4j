package evanq.game.net;

public interface INetManager {

	public void accpet(INetConnection connection);
	
	
	public void close(INetConnection connection);
	
	/**
	 * 心跳
	 */
	public void heat();
	
}
