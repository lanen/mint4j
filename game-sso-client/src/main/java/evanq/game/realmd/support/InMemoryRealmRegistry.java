package evanq.game.realmd.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import evanq.game.realmd.Realm;
import evanq.game.realmd.RealmRegistry;

/**
 * 
 * 存放在内存中的分区列表
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class InMemoryRealmRegistry implements RealmRegistry {

	/** 测试时候通过配置，提供分区 */
	private Map<String,String> a;
	
	@Override
	public Realm save(Realm realm) {			
		return null;
	}

	@Override
	public List<Realm> load() {
		
		ArrayList<Realm> realms = new ArrayList<Realm>();
		
		RealmImpl impl =  new RealmImpl(1);
		impl.setFlag(1);
		impl.setName("华南 - 01");
		
		realms.add(impl);
		
		return realms;
	}

	@Override
	public Realm findBy(int id) {

		return null;
	}
	
	
	protected List<Realm> r(){
		return null;
	}

}
