package evanq.game.realmd.support;

import java.util.List;

import evanq.game.realmd.Realm;
import evanq.game.realmd.RealmRegistry;
import evanq.game.realmd.RealmRegistryDao;

/**
 * 
 * 存放在内存中的分区列表
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class JpaRealmRegistry implements RealmRegistry {

	private RealmRegistryDao realmRegistryDao;
	
	@Override
	public Realm save(Realm realm) {
		
		return null;
	}

	@Override
	public List<Realm> load() {

		return null;
	}

	@Override
	public Realm findBy(int id) {

		return null;
	}

	public RealmRegistryDao getRealmRegistryDao() {
		return realmRegistryDao;
	}

	public void setRealmRegistryDao(RealmRegistryDao realmRegistryDao) {
		this.realmRegistryDao = realmRegistryDao;
	}

}
