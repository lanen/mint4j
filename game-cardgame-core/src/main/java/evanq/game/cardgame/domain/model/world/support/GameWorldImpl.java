package evanq.game.cardgame.domain.model.world.support;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class GameWorldImpl extends AbstractGameWorld  {
	
	public GameWorldImpl() {	
		super();
	}

	@Override
	public void start() {
		
		//
		WorldUtils.controllers().atfterStart();
	}

	@Override
	public void stop() {
		
	}

	@Override
	public void process() {
		
	}

}
