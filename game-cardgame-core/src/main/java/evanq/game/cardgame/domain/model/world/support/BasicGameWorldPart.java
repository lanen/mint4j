package evanq.game.cardgame.domain.model.world.support;

import evanq.game.cardgame.domain.model.world.GameWorldPart;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class BasicGameWorldPart implements GameWorldPart {

	@Override
	public void buildPart() {
		System.out.println("BasicGameWorldPart.buildPart()");
		initControllers();
	}
	
	/**
	 * 
	 */
	private void initControllers(){
		
		WorldUtils.services = new ServiceManagerImpl();
		
//		MovementController movementController = new MovementController();
//		WorldUtils.controllers.add(MovementController.class,movementController);

	}
	
}
