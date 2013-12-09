package evanq.game.di;

import evanq.game.di.impl.SpringDI;


/**
 * 依赖
 * @author Evan
 *
 */
public abstract class DIEngine {

	public abstract void start();
	public abstract void stop();
	
	public abstract <T> T instanceOf(Class<T> clazz );
	
	private static class Singleton {
		public static DIEngine INSTANCE = new SpringDI();
	}

	public static DIEngine getInstance() {
		return Singleton.INSTANCE;
	}

	protected DIEngine() {
	}
	
}
