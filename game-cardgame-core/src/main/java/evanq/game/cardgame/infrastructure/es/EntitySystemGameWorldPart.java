package evanq.game.cardgame.infrastructure.es;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.artemis.World;

import evanq.game.cardgame.domain.model.world.GameWorldPart;
import evanq.game.cardgame.domain.model.world.support.WorldUtils;
import evanq.game.cardgame.infrastructure.es.systems.SceneSystem;
import evanq.game.cardgame.infrastructure.services.EntitySystemService;
import evanq.game.cardgame.infrastructure.services.support.EntitySystemServiceImpl;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class EntitySystemGameWorldPart implements GameWorldPart {

	
	private Logger logger = LoggerFactory.getLogger(EntitySystemGameWorldPart.class);
	
	private World entityWorld;
	
	public EntitySystemGameWorldPart() {

	}
	
	
	@Override
	public void buildPart() {
		
		
		entityWorld = new World();
		entityWorld.initialize();
		
		
		entityWorld.setSystem(new SceneSystem());
		
		initEntityController();
		
		
		startEntitySystem();
	}

	private void initEntityController(){
		
//		IPlayerEntityController impl = new PlayerEntityControllerImpl(entityWorld);
//		WorldUtils.services().add(IPlayerEntityController.class,impl);
		
		EntitySystemService impl = new EntitySystemServiceImpl(entityWorld);
		WorldUtils.services().add(EntitySystemService.class,impl);
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
