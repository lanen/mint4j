package evanq.game.net;

public interface INetConnectionStateListener {
	
	public void connectionStateChanged(INetConnection connection,NetConnectionState state);
	
}
