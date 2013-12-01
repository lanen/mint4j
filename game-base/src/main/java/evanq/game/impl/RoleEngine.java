package evanq.game.impl;

import evanq.game.facade.IRoleFacade;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RoleEngine implements IRoleFacade {


	private static class Singleton {
		public static RoleEngine INSTANCE = new RoleEngine();
	}

	public static RoleEngine getInstance() {
		return Singleton.INSTANCE;
	}

	private RoleEngine() {
	}

	@Override
	public void createRole() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectRole() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRole() {
		// TODO Auto-generated method stub
		
	}
	
}
