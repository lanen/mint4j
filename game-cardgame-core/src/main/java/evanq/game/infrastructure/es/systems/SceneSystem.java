package evanq.game.infrastructure.es.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;

import evanq.game.infrastructure.es.components.Scene;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class SceneSystem extends EntityProcessingSystem {

	public SceneSystem() {
		super(Aspect.getAspectForAll(Scene.class));
	}

	@Override
	protected void process(Entity e) {
		System.out.println("SceneSystem.process()");
	}

}
