package evanq.game.realmd;

import java.util.List;

import evanq.game.realmd.entity.Realmdlist;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface RealmRegistryDao {
	
	public Realmdlist save(Realmdlist entity);
	
	public Realmdlist delete(Realmdlist entity);
	
	public List<Realmdlist> getAllRealm();
	
}
