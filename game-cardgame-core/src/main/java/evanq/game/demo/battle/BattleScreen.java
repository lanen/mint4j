package evanq.game.demo.battle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class BattleScreen implements Screen {

	private Game game;
	/**
	 * 背景图
	 */
	private Texture backgroundImage;

	/**
	 * 正投影摄像机
	 */
	private OrthographicCamera camera;

	private SpriteBatch batch;

	Rectangle bucket;
	Vector3 touchPos = new Vector3();

	
	public BattleScreen(Game game) {
		this.game = game;
		
		Gdx.app.log("BattleDemo", "Create Demo for Battle.");

		backgroundImage = new Texture(
				Gdx.files.internal("assets/textures/bucket.png"));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, ScreenUtils.width(), ScreenUtils.height());

		batch = new SpriteBatch();

		// 屏幕中央
		bucket = new Rectangle();
		bucket.x = ScreenUtils.width() / 2 - 128 / 2;
		bucket.y = 20;
		bucket.width = 128;
		bucket.height = 128;

	}
	
	@Override
	public void render(float delta) {
		// 设置背景色
		Gdx.gl.glClearColor(1f, 1f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(backgroundImage, bucket.x, bucket.y);
		batch.end();

		if (Gdx.input.isTouched()) {
			
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			bucket.x = touchPos.x - bucket.width / 2;
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
		// TODO Auto-generated method stub
		backgroundImage.dispose();

		batch.dispose();

	}

}
