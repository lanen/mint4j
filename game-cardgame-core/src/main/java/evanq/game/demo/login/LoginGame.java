package evanq.game.demo.login;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class LoginGame extends Game {

	private Stage stage;
	
	@Override
	public void create() {
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		
		
		
		//
		TextButtonStyle style = new TextButtonStyle();
		style.font = new BitmapFont();
		
		TextButton button1 = new TextButton("Button 1", style);
		table.add(button1);
		
	}

	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
	}

	public void render(float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

		Table.drawDebug(stage); // This is optional, but enables debug lines for
								// tables.
	}
	
	public void dispose() {
		stage.dispose();
	}


}
