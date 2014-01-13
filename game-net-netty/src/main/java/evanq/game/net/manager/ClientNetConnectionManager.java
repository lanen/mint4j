package evanq.game.net.manager;

import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.AbstractPacket;
import evanq.game.net.INetConnection;
import evanq.game.net.INetConnectionFSM;
import evanq.game.net.MappingNetConnectionHolder;
import evanq.game.net.NetServiceType;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;

/**
 * 
 * 作为客户端连接持有的，管理本身的连接管理器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class ClientNetConnectionManager extends AbstractNetConnectionManager {

	private Trace logger = LogSystem.getDefaultTrace(ClientNetConnectionManager.class);
	
	public ClientNetConnectionManager() {
		super(NetServiceType.CLIENT);
	}
		
	@Override
	protected INetConnectionFSM createNetConnectionFSM(INetConnection connection) {
		ClientNetConnectionFSM fsm = new ClientNetConnectionFSM(this,connection);
		return fsm;
	}

	//key bind 是如何设计的?键盘事件，与响应事件。
	//holder 可能的职责，持有连接；提供网络服务给单个玩家
	//manager 提供广播，定时检查连接的功能。
	class ClientConnectionHolder extends MappingNetConnectionHolder {
		
		//接受连接
		private int indexer = 0 ;
		
		@Override
		public void send(AbstractPacket packet) {
			//TODO 发送数据包，讲数据包路由
			
		}
		
	}
		
}
