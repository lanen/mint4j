package evanq.game.demo.tiles;

import com.badlogic.gdx.Game;

public class TileApp extends Game{

	@Override
	public void create() {
		setScreen(new TileScreen(this));		
	}

	
}
