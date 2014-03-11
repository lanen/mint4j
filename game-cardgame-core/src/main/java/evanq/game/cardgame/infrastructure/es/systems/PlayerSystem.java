package evanq.game.cardgame.infrastructure.es.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;

import evanq.game.cardgame.infrastructure.es.components.Pet;
import evanq.game.cardgame.infrastructure.es.components.Player;
import evanq.game.cardgame.infrastructure.es.components.Position;

public class PlayerSystem extends EntityProcessingSystem{

	
	
	public PlayerSystem() {
		super(Aspect.getAspectForAll(Player.class, Position.class,Pet.class));
	}
	
	@Override
	protected void process(Entity e) {
		
	}

}
