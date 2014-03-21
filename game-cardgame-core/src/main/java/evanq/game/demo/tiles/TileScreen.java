package evanq.game.demo.tiles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class TileScreen implements Screen {

	private Game game;

	private TiledMap map;
	private TiledMapRenderer renderer;
	private OrthographicCamera camera;
	private OrthoCamController cameraController;
	private AssetManager assetManager;
	private Texture tiles;
	private Texture texture;
	private BitmapFont font;
	private SpriteBatch batch;
	
	public TileScreen(Game game) {
		this.game = game;
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, (w / h) * 320, 320);
		camera.update();

		cameraController = new OrthoCamController(camera);
		Gdx.input.setInputProcessor(cameraController);

		font = new BitmapFont();
		batch = new SpriteBatch();

//		{
//			tiles = new Texture(Gdx.files.internal("assets/textures/bucket.png"));
//			TextureRegion[][] splitTiles = TextureRegion.split(tiles, 32, 32);
//			map = new TiledMap();
//			MapLayers layers = map.getLayers();
//			for (int l = 0; l < 20; l++) {
//				TiledMapTileLayer layer = new TiledMapTileLayer(150, 100, 32, 32);
//				for (int x = 0; x < 150; x++) {
//					for (int y = 0; y < 100; y++) {
//						int ty = (int)(Math.random() * splitTiles.length);
//						int tx = (int)(Math.random() * splitTiles[ty].length);
//						Cell cell = new Cell();
//						cell.setTile(new StaticTiledMapTile(splitTiles[ty][tx]));
//						layer.setCell(x, y, cell);
//					}
//				}
//				layers.add(layer);
//			}
//		}

		map = new TmxMapLoader().load("data/maps/tiled/demo.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
	}
	
	
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(100f / 255f, 100f / 255f, 250f / 255f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
	
		renderer.setView(camera);
		renderer.render();
	
		
		batch.begin();
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
		batch.end();
		
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
		
	}

}
