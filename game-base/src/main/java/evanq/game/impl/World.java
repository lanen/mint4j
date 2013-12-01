package evanq.game.impl;

import evanq.game.facade.IWorldFacade;

/**
 * @author Evan cppmain@gmail.com
 *
 */
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
		throw new UnsupportedOperationException("World.start()");
	}

	@Override
	public void stop() {
		throw new UnsupportedOperationException("World.stop()");
	}

	@Override
	public void join() {
		throw new UnsupportedOperationException("World.join()");
	}

	@Override
	public void leave() {
		throw new UnsupportedOperationException("World.leave()");
	}
	
}
