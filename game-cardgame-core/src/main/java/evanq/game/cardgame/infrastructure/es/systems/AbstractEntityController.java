package evanq.game.cardgame.infrastructure.es.systems;

import com.artemis.World;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractEntityController {

	protected World world;
	
	public AbstractEntityController(World world) {
	
		if(null == world){
			throw new NullPointerException("world");
		}
		this.world = world;
	}
	
}
