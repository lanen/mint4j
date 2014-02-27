package evanq.game.realmd;

import java.util.List;

public interface RealmRegistry {

	public Realm save(Realm realm);
	
	public List<Realm> load();
	
	public Realm findBy(int id);
	
}
