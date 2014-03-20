package evanq.game.demo.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * 
 * label show FPS 
 * @author Evan cppmain@gmail.com
 *
 */
public class FPSLabel extends Label{

	public FPSLabel() {
		super("FPS: 0",new LabelStyle(new BitmapFont(), Color.BLACK));
		setY(ScreenUtils.height()-30);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		
		setText("FPS: " + Gdx.graphics.getFramesPerSecond());
		setX(10); 

	}
	
}
