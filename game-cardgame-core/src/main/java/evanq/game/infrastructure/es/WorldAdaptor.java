package evanq.game.infrastructure.es;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.artemis.World;
import com.artemis.managers.GroupManager;

import evanq.game.infrastructure.es.systems.SceneSystem;

/**
 * 先实现几个小应用，再考量
 * @author Evan cppmain@gmail.com
 *
 */
public final class WorldAdaptor {
	
	private Logger logger = LoggerFactory.getLogger(WorldAdaptor.class);

	private World entityWorld;

	public WorldAdaptor() {
		
		entityWorld = new World();
		
		entityWorld.setManager(new GroupManager());

		entityWorld.setSystem(new SceneSystem());
		
		entityWorld.initialize();
		startEntitySystem();

	}
	public World world(){
		return entityWorld;
	}
	private Thread thread;
	
	/**
	 * 
	 * 在线程中启动实体管理
	 * 
	 */
	public void startEntitySystem(){
		
		if(null == thread){
			thread = new Thread(new Run(),"ES-Thread");
			thread.start();
		}
	}
	
	class Run implements Runnable {

		@Override
		public synchronized void run() {
			
			logger.info("启动实体管理线程");
			
			while(true){
				
				try{
					entityWorld.process();					
				}catch(Exception e){
					e.printStackTrace();
					break;
				}
				
				try {
					wait(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			thread = null;
		}
		
	}
	
}
