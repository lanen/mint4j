package evanq.game.module.rpg.impl;

import evanq.game.env.IEnvironment;
import evanq.game.module.rpg.IWorldFacade;

/**
 * 
 * @author Evan
 *
 */
public class WorldInstance implements IWorldFacade, Runnable {

	private static class Singleton {
		public static WorldInstance INSTANCE = new WorldInstance();
	}

	public static WorldInstance get() {
		return Singleton.INSTANCE;
	}

	private WorldInstance() {
	}

	@Override
	public void start(String name, IEnvironment environment) {
		
	}
	
	@Override	
	public void stop() {
		
	}

	@Override
	public void run() {
	
	}

}
