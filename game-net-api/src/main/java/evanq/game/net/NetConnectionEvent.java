package evanq.game.net;

public enum NetConnectionEvent {

	CREATE_OK,
	
	
	CREATE_FAILED,
	
	
	AUTH_OK,
	
	
	AUTH_FAILED,
	
	
	READ,
	
	WRITE,
	
	
	/** 心跳 */
	PING,
	/** 心跳收到 */
	PING_CHECK,
	
	
	CLOSE,
	DELAYED_CLOSE
}
