package evanq.game.realmd;

import java.io.Serializable;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public interface Realm extends Serializable,Cloneable {

	
	public int getId();

	public String getName();

	public boolean isEnable();	
	
	public int getPort();
	
	public String getAddress();
	
	public int getIcon();
	
	public RealmStatus getStatus();
	
	public int getPopulation();
}
