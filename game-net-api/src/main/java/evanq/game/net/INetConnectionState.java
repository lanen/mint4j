package evanq.game.net;

public interface INetConnectionState {

	public NetConnectionState state();
	
	public void update(INetConnection connection,NetConnectionEvent event);
}
