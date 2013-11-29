package evanq.game.impl;

import evanq.game.design_traits.IEngine;
import evanq.game.module.IModule;
import evanq.game.module.IModuleware;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ItemEngine implements IModuleware ,IEngine{

	private static class Singleton {
		public static ItemEngine INSTANCE = new ItemEngine();
	}

	public static ItemEngine getInstance() {
		return Singleton.INSTANCE;
	}

	private ItemEngine() {
	}

	@Override
	public IModule getModule() {
		return null;
	}

	@Override
	public void setModule(IModule m) {
		
	}
	
}
