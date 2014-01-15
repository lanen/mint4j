package evanq.game.net.impl;

import java.util.concurrent.ConcurrentMap;

import evanq.game.helper.New;
import evanq.game.net.DefaultNetServiceHandler;
import evanq.game.net.DefaultPacketAllocator;
import evanq.game.net.INetService;
import evanq.game.net.NetConnectionType;
import evanq.game.net.NetServiceAdaptor;
import evanq.game.net.NetServiceType;
import evanq.game.net.manager.ClientNetConnectionManager;
import evanq.game.net.manager.ServerNetConnectionManager;
import evanq.game.net.sapi.INetServiceFactory;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class NettyNetInterfaceFactory implements INetServiceFactory {
	//缓存服务器，避免重复创建
	//TODO 在服务器销毁时候要留意
	ConcurrentMap<Integer, INetService> mapping;

	public NettyNetInterfaceFactory(){
		mapping = New.newConcurrentHashMap();
	}

	@Override
	public INetService getNetService(int port) {
		if(! mapping.containsKey(port)){			
			DefaultNetServiceHandler defaultNetServiceHandler = server();
			NetServiceAdaptor adaptor = new NetServiceAdaptor(NetServiceType.SERVER,port,defaultNetServiceHandler);
			mapping.put(port, adaptor);
		}

		return mapping.get(port);
	}

	@Override
	public INetService getNetService(NetConnectionType connectionType,
			String host, int port) {
		
		DefaultNetServiceHandler defaultNetServiceHandler = client();

		NetServiceAdaptor adaptor = new NetServiceAdaptor(NetServiceType.CLIENT,host,port,defaultNetServiceHandler);
		adaptor.connectionType(connectionType);
		
		return adaptor;
	}
	private DefaultNetServiceHandler server(){
		ServerNetConnectionManager serverNetConnectionManager = new ServerNetConnectionManager();
		
		DefaultNetServiceHandler netServiceHandler = new DefaultNetServiceHandler(serverNetConnectionManager,DefaultPacketAllocator.getInstance());
		return netServiceHandler;

	}
	
	//TODO 创建客户端的连接管理器
	DefaultNetServiceHandler singletonForClientNetServiceHandler;
	private DefaultNetServiceHandler client(){
		if(null == singletonForClientNetServiceHandler){
			ClientNetConnectionManager clientNetConnectionManager  = new ClientNetConnectionManager();
			singletonForClientNetServiceHandler = new DefaultNetServiceHandler(clientNetConnectionManager,DefaultPacketAllocator.getInstance());
			
		}
		return singletonForClientNetServiceHandler;
	}
	
}
