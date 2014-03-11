package evanq.game.cardgame.infrastructure.controller;

import evanq.game.player.MPlayer;

public interface IPlayerController {

	public void join(MPlayer player);
	
	public void leave(MPlayer leave);
	
}
