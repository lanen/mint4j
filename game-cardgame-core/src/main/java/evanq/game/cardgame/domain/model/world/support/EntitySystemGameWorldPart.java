package evanq.game.cardgame.domain.model.world.support;

import com.artemis.World;

import evanq.game.cardgame.domain.model.world.GameWorldPart;
import evanq.game.cardgame.infrastructure.controller.IPlayerEntityController;
import evanq.game.cardgame.infrastructure.es.systems.PlayerEntityControllerImpl;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class EntitySystemGameWorldPart implements GameWorldPart {

	private World entityWorld;
	
	public EntitySystemGameWorldPart() {

	}
	
	@Override
	public void buildPart() {
		
		System.out.println("EntitySystemGameWorldPart.buildPart()");
		
		entityWorld = new World();
		entityWorld.initialize();
		
		initEntityController();
		
	}

	private void initEntityController(){
		
		IPlayerEntityController impl = new PlayerEntityControllerImpl(entityWorld);
		WorldUtils.services.add(IPlayerEntityController.class,impl);
	}
}
