package evanq.game.cardgame.domain.model.world.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.cardgame.domain.model.world.GameWorldPart;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class BasicGameWorldPart implements GameWorldPart {

	private Logger logger = LoggerFactory.getLogger(BasicGameWorldPart.class);
	
	@Override
	public void buildPart() {
		logger.info("BasicGameWorldPart.buildPart()");
	}
}
