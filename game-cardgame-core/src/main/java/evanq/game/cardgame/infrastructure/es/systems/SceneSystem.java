package evanq.game.cardgame.infrastructure.es.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;

import evanq.game.cardgame.infrastructure.es.components.Scene;

public class SceneSystem extends EntityProcessingSystem {

	public SceneSystem() {
		super(Aspect.getAspectForAll(Scene.class));
	}

	@Override
	protected void process(Entity e) {
		System.out.println("SceneSystem.process()");
	}

}
