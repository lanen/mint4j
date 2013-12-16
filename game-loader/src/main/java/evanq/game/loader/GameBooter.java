package evanq.game.loader;

import evanq.game.concurrent.loop.AbstractTask;
import evanq.game.concurrent.loop.DefaultLoopGroup;
import evanq.game.concurrent.loop.ITask;
import evanq.game.env.impl.ConsoleArgumentOptions;
import evanq.game.env.impl.SimpleEnvironment;
import evanq.game.env.impl.SystemPropertyOptions;
import evanq.game.module.rpg.IWorldFacade;
import evanq.game.rpg.impl.WorldInstance;

/**
 * 
 * @author Evan
 *
 */
public class GameBooter {

	public static void main(String[] args) throws Exception {
		//Impl(args);
		
		testSingleThreadTask();
	}
	
	public static void Impl(String[] args){		
		
		//step 1. 封装来自命令行的参数
		
		SystemPropertyOptions sysprop = new SystemPropertyOptions();
		ConsoleArgumentOptions option = new ConsoleArgumentOptions(args);
		
		//step 2. 准备游戏世界
		SimpleEnvironment env = new SimpleEnvironment();
	
		env.accept(sysprop);
		env.accept(option);
		
		env.refress();
		
		if( ! env.isValidForRunning()){
			env.dump();
		}
		
		env.notifySetup();
		
		//step 3. 建立游戏世界实例
		IWorldFacade world = WorldInstance.get();		
		world.start("钓鱼岛",env);
		
	}
	
	static class SimpleTask extends AbstractTask  {

		public SimpleTask() {
			super(null);
		}
		@Override
		public boolean isActived() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isOpen() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isDeActived() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isDeRegistered() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		protected void doRegister() {
			// TODO Auto-generated method stub
			
			
			System.out.println("GameBooter.SimpleTask.doRegister()");
		}

		@Override
		protected void doActive() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void doDeRegister() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void doDeActive() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void doOpen() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void run() {
			// TODO Auto-generated method stub
			System.out.println("GameBooter.SimpleTask.run()");
		}
		
		
	}
	
	private static void testSingleThreadTask(){
		
		DefaultLoopGroup group = new DefaultLoopGroup(1);
		
		ITask task = new SimpleTask();
		
		group.register(task);
		
		Object lock = new Object();
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
