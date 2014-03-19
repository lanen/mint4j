package evanq.game.cardgame.infrastructure.es;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.cardgame.domain.model.world.GameWorldPart;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class EntitySystemGameWorldPart implements GameWorldPart {

	private Logger logger = LoggerFactory.getLogger(EntitySystemGameWorldPart.class);
	private WorldAdaptor worldAdaptor;
	public EntitySystemGameWorldPart() {

	}
	
	@Override
	public void buildPart() {
		logger.info("EntitySystemGameWorldPart.buildPart()");
		
		worldAdaptor = new WorldAdaptor();
		
	}

}
