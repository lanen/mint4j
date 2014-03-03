package evanq.game.playbox;

import evanq.game.realmd.GameAccount;
import evanq.game.realmd.GameIndentify;
import evanq.game.realmd.Realm;


/**
 * 
 * 
 * GameIndentify will load from system build and system name
 * 
 * Realm from url or last access.
 * 
 * GameAccount from session.
 * 
 * PlayBoxView support display setting.
 * 
 * Playbox wrap game
 * 
 * Playbox with frame
 * 
 * Playbox labelfor account
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface PlayBox {
	
	public PlayBox wrap(GameIndentify gameIndentify, Realm realm);
	
	public PlayBox wrap(GameIndentify gameIndentify, Realm realm, DisplayMode frame);
	
	public PlayBox with(DisplayMode frame);

	public PlayBox labelFor(GameAccount account);
	
	public DisplayMode getDisplayMode();
	
	public PlayBoxView view();
	
}
