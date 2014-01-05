package evanq.game.net;


public abstract class AbstractNetConnection implements INetConnection {
	
	//授权完毕后，就有明确的连接类型
	protected NetConnectionType type;
	
	protected AbstractNetConnection(NetConnectionType type){
		this.type = type;
	}

	@Override
	public NetConnectionType type() {
		return type;
	}


	private INetConnectionFSM fsm;
	
	@Override
	public INetConnectionFSM fsm() {
		return fsm;
	}


	@Override
	public INetConnectionFSM fsm(INetConnectionFSM fsm) {
		if (null == fsm) {
			throw new NullPointerException("fsm");
		}
		if(this.fsm !=null){
			throw new IllegalAccessError("不可重复设定状态机");
		}
		
		this.fsm = fsm;
		
		return this.fsm;
	}

}
