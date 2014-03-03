package evanq.game.realmd.support;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.core.io.Resource;

import evanq.game.realmd.Realm;
import evanq.game.realmd.RealmRegistry;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class JsonRealmRegistry implements RealmRegistry {

	private InMemoryRealmRegistry inMemory;
	
	
	
	public JsonRealmRegistry(File file) throws FileNotFoundException {
		
		if(null == file){
			throw new NullPointerException("file");
		}
		
		if(!file.exists()){
			throw new FileNotFoundException();
		}
		
		loadRegistry(file);
		inMemory = new InMemoryRealmRegistry();
	}

	@Override
	public Realm save(Realm realm) {
		inMemory.save(realm);
		return realm;
	}

	@Override
	public List<Realm> load() {
		return inMemory.load();
	}

	@Override
	public Realm findBy(int id) {
		return inMemory.findBy(id);
	}
	
	
	protected void loadRegistry(File file){
		
		
		
	}
	
	public static void main(String[] args) {
		
		File file = new File("classpath:cas_client.properties");
		try {
			JsonRealmRegistry jsonRealmRegistry = new JsonRealmRegistry(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
