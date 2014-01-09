package evanq.game.rpg.impl;

import evanq.game.env.IEnvironment;
import evanq.game.module.rpg.IWorldFacade;

/**
 * 
 * @author Evan
 *
 */
public class WorldInstance implements IWorldFacade, Runnable {

	private static class Singleton {
		public static WorldInstance INSTANCE = new WorldInstance();
	}

	public static WorldInstance get() {
		return Singleton.INSTANCE;
	}

	private WorldInstance() {
	}
	
	static final String WORLD_STAT_THREAD_NAME = "world_stat";	
	

	@Override
	public void start(String name, IEnvironment environment) {
		
		//step 1.初始化运行世界必备组件
		
		
		//step 2. IO 组件，Agent.
		Thread io = new Thread();
	
		//游戏线程
		Thread worldThread = new Thread(this,"world");
		worldThread.start();
		
		SceneManager.getInstance();
		
		
		//统计任务
		Thread t__ = new Thread(new WorldStats(), WORLD_STAT_THREAD_NAME);
		t__.start();
		
		

		
	}
	
	@Override	
	public void stop() {
		
		//关闭游戏世界
		//DIEngine.getInstance().stop();

	}

	@Override
	public void run() {
		//step 3. 线程发生
		boolean ff = true;
		
		while(ff){
		
			//consumer and supply pattern
			
			//select event
			//dipatch event
		}
		
		stop();
	}

}
