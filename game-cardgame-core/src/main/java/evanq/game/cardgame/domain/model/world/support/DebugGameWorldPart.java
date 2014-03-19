package evanq.game.cardgame.domain.model.world.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.cardgame.domain.model.world.GameWorldPart;
import evanq.game.cardgame.interfaces.dto.LoginDTO;
import evanq.game.net.DefaultPacketAllocator;

/**
 * 
 * Running debug tool when build the world.
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DebugGameWorldPart implements GameWorldPart {

	
	private Logger logger = LoggerFactory.getLogger(DebugGameWorldPart.class);
	
	@Override
	public void buildPart() {
		logger.info("DebugGameWorldPart.buildPart()");
	
		LoginDTO loginDto = DefaultPacketAllocator.newPacket(LoginDTO.class);
		loginDto.execute();
		
	}

}
