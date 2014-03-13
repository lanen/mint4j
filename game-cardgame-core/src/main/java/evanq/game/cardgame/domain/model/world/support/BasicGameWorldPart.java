package evanq.game.cardgame.domain.model.world.support;

import evanq.game.cardgame.domain.model.world.GameWorldPart;
import evanq.game.cardgame.infrastructure.controller.IPlayerController;
import evanq.game.cardgame.infrastructure.controller.support.PlayerControllerImpl;

/**
 * 
 * ����֧�ֳ������
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
	 * ������ע�� IController
	 */
	private void initControllers(){
		
		WorldUtils.services = new ServiceManagerImpl();
		
		IPlayerController playerController = new PlayerControllerImpl();
		WorldUtils.services.add(IPlayerController.class,playerController);
		
//		MovementController movementController = new MovementController();
//		WorldUtils.controllers.add(MovementController.class,movementController);

	}
	
}
