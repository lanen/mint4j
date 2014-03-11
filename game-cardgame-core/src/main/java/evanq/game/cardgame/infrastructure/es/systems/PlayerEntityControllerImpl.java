package evanq.game.cardgame.infrastructure.es.systems;

import com.artemis.Entity;
import com.artemis.World;

import evanq.game.cardgame.infrastructure.controller.IPlayerEntityController;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class PlayerEntityControllerImpl extends AbstractEntityController implements IPlayerEntityController{

	public PlayerEntityControllerImpl(World world) {
		super(world);
	}

	@Override
	public void join( ) {
		System.out.println("PlayerEntityControllerImpl.join()");
		Entity entity = world.createEntity();
	}

	@Override
	public void leave( ) {
		
	}
	
}
