package evanq.game.impl;

import evanq.game.design_traits.IEngine;
import evanq.game.module.IModule;
import evanq.game.module.IModuleware;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RoleEngine implements IModuleware, IEngine {

	private static class Singleton {
		public static RoleEngine INSTANCE = new RoleEngine();
	}

	public static RoleEngine getInstance() {
		return Singleton.INSTANCE;
	}

	private RoleEngine() {
	}

	@Override
	public IModule getModule() {
		return null;
	}

	@Override
	public void setModule(IModule m) {
		
	}
	
}
