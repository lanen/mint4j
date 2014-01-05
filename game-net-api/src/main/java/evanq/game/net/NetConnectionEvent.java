package evanq.game.net;

public enum NetConnectionEvent {

	CREATE_OK,
	CREATE_FAILED,
	AUTH_OK,
	AUTH_FAILED,
	READ,
	WRITE,
	
	HANG,
	CLOSE,
	DELAYED_CLOSE
}
