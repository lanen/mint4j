package evanq.game.demo.battle;

import com.badlogic.gdx.Game;

public class BattleDemo extends Game {

	@Override
	public void create() {
		this.setScreen(new BattleMainMenuScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

}
