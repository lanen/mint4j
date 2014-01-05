package evanq.game.net;

public interface INetConnectionFSM {

	public void update(INetConnectionState state);
	
	public void fireEvent(NetConnectionEvent event);
}
