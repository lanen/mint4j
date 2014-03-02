package evanq.game.realmd;

import java.io.Serializable;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public interface Realm extends Serializable,Cloneable {

	
	public RealmIndentify getId();

	public String getName();

	public boolean isEnable();
	
	public String getGateUrl();
	
	public int getPort();
	
	public String getAddress();
	
	public int getIcon();
	
	public RealmStatus getStatus();
	
	public int getPopulation();
}
