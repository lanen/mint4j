package evanq.game.net.impl;

import evanq.game.net.INetInterfaceFactory;
import evanq.game.net.sapi.INetInterfaceFactoryBinder;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class StaticNetInterfaceBinder implements INetInterfaceFactoryBinder {
	
	private static StaticNetInterfaceBinder INSTANCE = new StaticNetInterfaceBinder();

	public static StaticNetInterfaceBinder getInstance(){
		return INSTANCE;
	}
	
	private StaticNetInterfaceBinder(){
	    throw new UnsupportedOperationException("This code should have never made it into net-api.jar");
	}
	
	@Override
	public INetInterfaceFactory getINetInterfaceFactory() {
		throw new UnsupportedOperationException("This code should have never made it into net-api.jar");
		
	}
	
}
