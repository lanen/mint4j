package evanq.game.client;

import java.net.URL;

import org.lwjgl.LWJGLException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

import TWLSlick.TWLStateBasedGame;
import de.matthiasmann.twl.GUI;
import de.matthiasmann.twl.renderer.lwjgl.LWJGLRenderer;
import de.matthiasmann.twl.theme.ThemeManager;
import de.matthiasmann.twleffects.lwjgl.LWJGLEffectsRenderer;
import evanq.game.client.widget.LoginWidget;


public class SimpleSlickGame extends TWLStateBasedGame {
	
	public SimpleSlickGame(String title) {
		super(title);
		
		
	}

	
	public static void main(String[] args) {
		
		
		SimpleSlickGame game = new SimpleSlickGame("My 我的中文游戏");

		try {
			AppGameContainer container = new AppGameContainer(game);
			container.setDisplayMode(800, 600, false);
			container.start();
		} catch (SlickException  e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected URL getThemeURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {	
		
	}

}
