package evanq.game.net.impl;

import evanq.game.net.sapi.INetInterfaceFactory;
import evanq.game.net.sapi.INetInterfaceFactoryBinder;

/**
 * 在这里实现网络模块
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class StaticNetInterfaceBinder implements INetInterfaceFactoryBinder {
	
	NettyNetInterfaceFactory factory = new NettyNetInterfaceFactory();
	
	@Override
	public INetInterfaceFactory getINetInterfaceFactory() {
		return factory;
	}
	
	private StaticNetInterfaceBinder(){
		init();
	}
	
	private static StaticNetInterfaceBinder INSTANCE = new StaticNetInterfaceBinder();
	
	public static StaticNetInterfaceBinder getInstance(){
		
		return INSTANCE;
	}
	
	static void init(){
		System.out.println("初始化静态绑定期");
	}
}
