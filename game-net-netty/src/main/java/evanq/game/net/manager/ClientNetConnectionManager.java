package evanq.game.net.manager;

import java.util.ArrayList;

import evanq.game.net.AbstractNetConnectionHolder;
import evanq.game.net.AbstractNetConnectionManager;
import evanq.game.net.INetConnection;
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
	public void accpet(INetConnection connection) {
		logger.info("完成连接创建");
		
	}

	@Override
	public void close(INetConnection connection) {
		logger.info("关闭连接");

	}
	
	//key bind 是如何设计的?键盘事件，与响应事件。
	//holder 可能的职责，持有连接；提供网络服务给单个玩家
	//manager 提供广播，定时检查连接的功能。
	class ClientConnectionHolder extends AbstractNetConnectionHolder {
		//客户端与多个服务端口交互
		//设计一个合理且通用的方式来管理连接
		INetConnection nc1;
		INetConnection nc2;
		INetConnection nc3;
		INetConnection nc4;
		INetConnection nc5;
		
		//
	}
	
	class SingleConnectionHolder extends AbstractNetConnectionHolder {
		
		SingleConnectionHolder(INetConnection connection) {
		}
		
	}

	class MultiConnectionHolder extends AbstractNetConnectionHolder {
	
		ArrayList<SingleConnectionHolder> connection;
		
		MultiConnectionHolder() {
		}
		
		SingleConnectionHolder wrap(INetConnection connection) {
			return new SingleConnectionHolder(connection);
		}
	}
	
	
}
