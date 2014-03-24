package evanq.game.net.impl;

import evanq.game.net.sapi.INetServiceFactory;
import evanq.game.net.sapi.INetServiceFactoryBinder;

/**
 * 在这里实现网络模块
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class StaticNetServiceFactoryBinder implements INetServiceFactoryBinder {
	
	NettyNetInterfaceFactory factory = new NettyNetInterfaceFactory();
	
	@Override
	public INetServiceFactory getINetServiceFactory() {
		return factory;
	}
	
	private StaticNetServiceFactoryBinder(){
		init();
	}
	
	private static StaticNetServiceFactoryBinder INSTANCE = new StaticNetServiceFactoryBinder();
	
	public static StaticNetServiceFactoryBinder getInstance(){
		
		return INSTANCE;
	}
	
	static void init(){
		
		
	}
}
