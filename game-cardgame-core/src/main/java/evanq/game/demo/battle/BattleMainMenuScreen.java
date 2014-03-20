package evanq.game.demo.battle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BattleMainMenuScreen implements Screen {

	private Game game;
	/**
	 * 正投影摄像机
	 */
	private OrthographicCamera camera;
	
	
	private SpriteBatch menuSprite;
	
	public BitmapFont font;
	
	public BattleMainMenuScreen(Game game) {
		this.game = game;
		
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, ScreenUtils.width(), ScreenUtils.height());
		
		menuSprite = new SpriteBatch();
		font = new BitmapFont();
	}
	
	@Override
	public void render(float delta) {

        camera.update();
        menuSprite.setProjectionMatrix(camera.combined);

        menuSprite.begin();
        font.draw(menuSprite, "Welcome to Drop!!! ", 100, 150);
        font.draw(menuSprite, "Tap anywhere to begin!", 100, 100);
        menuSprite.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new BattleStage(game));
            dispose();
        }
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		
		menuSprite.dispose();
		font.dispose();
	}

}
