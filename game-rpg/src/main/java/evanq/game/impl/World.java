package evanq.game.impl;

import evanq.game.facade.IWorldFacade;

public class World implements IWorldFacade {

	private static class Singleton {
		public static World INSTANCE = new World();
	}

	public static World getInstance() {
		return Singleton.INSTANCE;
	}

	private World() {
	}

	@Override
	public void start() {
		System.out.println("World.start()");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void join() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
	
	
}
