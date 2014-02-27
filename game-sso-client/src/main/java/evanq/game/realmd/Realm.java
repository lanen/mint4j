package evanq.game.realmd;

import java.io.Serializable;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public interface Realm extends Serializable {

	
	public RealmIndentify id();

	public String name();

	public boolean isEnable();
	
	
}
