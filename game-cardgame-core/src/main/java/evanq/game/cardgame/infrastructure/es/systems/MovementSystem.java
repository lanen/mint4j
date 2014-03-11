package evanq.game.cardgame.infrastructure.es.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;

import evanq.game.cardgame.infrastructure.es.components.Position;
import evanq.game.cardgame.infrastructure.es.components.Velocity;

public class MovementSystem extends EntityProcessingSystem {

	@Mapper ComponentMapper<Position> pm;
	@Mapper ComponentMapper<Velocity> vm;
	
	public MovementSystem() {		
		super(Aspect.getAspectForAll(Position.class, Velocity.class));
		
	}
	
	
	@Override
	protected void process(Entity e) {
		Position position = pm.get(e);
		Velocity velocity = vm.get(e);
		
		position.setX(position.getX() + velocity.getVectorX() * world.delta);
		position.setY(position.getY() + velocity.getVectorY() * world.delta);
	}

}
