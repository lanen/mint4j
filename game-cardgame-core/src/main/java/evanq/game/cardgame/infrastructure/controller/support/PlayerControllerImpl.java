package evanq.game.cardgame.infrastructure.controller.support;

import evanq.game.cardgame.domain.model.world.support.WorldUtils;
import evanq.game.cardgame.infrastructure.controller.IPlayerController;
import evanq.game.cardgame.infrastructure.controller.IPlayerEntityController;
import evanq.game.cardgame.infrastructure.controller.IPostContrust;
import evanq.game.player.MPlayer;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class PlayerControllerImpl implements IPlayerController , IPostContrust{

	private IPlayerEntityController playerEntityController;
	
	@Override
	public void join(MPlayer player) {
		
	
		playerEntityController.join(player);
	}

	@Override
	public void leave(MPlayer leave) {
		
		
		playerEntityController.leave(leave);
	}

	@Override
	public void atfterStart() {
		System.out.println("PlayerControllerImpl.atfterStart()");
		if(null == playerEntityController){
			System.out.println("playerEntityController init");
			
			playerEntityController = WorldUtils.controllers().get(IPlayerEntityController.class);
		}
	}

	
}
