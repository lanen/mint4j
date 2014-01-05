package evanq.game.net;

public class AbstractNetConnectionFSM implements INetConnectionFSM {

	private INetConnection connection;
	
	private INetConnectionState currentState;
	
	public AbstractNetConnectionFSM(INetConnection connection) {
		this.connection = connection;
		this.connection.fsm(this);
	}
	
	@Override
	public void update(INetConnectionState state) {
		this.currentState = state;
	}

	@Override
	public void fireEvent(NetConnectionEvent event) {
		this.currentState.update(connection,event);
	}

}
