package evanq.game.net.impl;

import evanq.game.net.sapi.INetServiceFactory;
import evanq.game.net.sapi.INetServiceFactoryBinder;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class StaticNetServiceFactoryBinder implements INetServiceFactoryBinder {
	
	private static StaticNetServiceFactoryBinder INSTANCE = new StaticNetServiceFactoryBinder();

	public static StaticNetServiceFactoryBinder getInstance(){
		return INSTANCE;
	}
	
	private StaticNetServiceFactoryBinder(){
	    throw new UnsupportedOperationException("This code should have never made it into game-net-api.jar");
	}
	
	@Override
	public INetServiceFactory getINetServiceFactory() {
		throw new UnsupportedOperationException("This code should have never made it into game-net-api.jar");
		
	}
	
}
