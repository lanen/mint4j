package evanq.game.realmd.support;

import java.util.ArrayList;
import java.util.List;

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
	
	
	private ArrayList<Realm> realms = new ArrayList<Realm>();
	
	@Override
	public Realm save(Realm realm) {			
		return null;
	}

	@Override
	public List<Realm> load() {		
		
		RealmImpl impl_1 =  new RealmImpl(1);
		
		impl_1.setFlag(1);
		impl_1.setName("Realm-2");
		impl_1.setAddress("127.0.0.1");
		impl_1.setPort(4401);
		impl_1.setPopulation(1);
		impl_1.setIcon(1);
		
		realms.add(impl_1);


		
		RealmImpl impl_2 =  new RealmImpl(2);
		
		impl_2.setFlag(1);
		impl_2.setName("Realm-2");
		impl_2.setAddress("127.0.0.1");
		impl_2.setPort(4101);
		impl_2.setPopulation(1);
		impl_2.setIcon(1);
		
		realms.add(impl_2);



		RealmImpl impl_3 =  new RealmImpl(3);
		
		impl_3.setFlag(1);
		impl_3.setName("Realm-3");
		impl_3.setAddress("127.0.0.1");
		impl_3.setPort(4301);
		impl_3.setPopulation(1);
		impl_3.setIcon(1);
		
		realms.add(impl_3);

		RealmImpl impl_4 =  new RealmImpl(4);
		
		impl_4.setFlag(1);
		impl_4.setName("Realm-4");
		impl_4.setAddress("127.0.0.1");
		impl_4.setPort(4401);
		impl_4.setPopulation(1);
		impl_4.setIcon(1);
		
		realms.add(impl_4);	
		
		return realms;
	}

	@Override
	public Realm findBy(int id) {

		for (Realm r : realms) {
			if(r.getId()==id){
				return r;
			}
		}
		return null;
	}
	
}
