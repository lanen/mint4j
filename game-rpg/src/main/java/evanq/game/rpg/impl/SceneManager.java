package evanq.game.rpg.impl;

import evanq.game.concurrent.loop.AbstractTask;
import evanq.game.concurrent.loop.DefaultLoopGroup;
import evanq.game.concurrent.loop.ICommand;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class SceneManager extends AbstractTask {

	private static class Singleton {
		public static SceneManager INSTANCE = new SceneManager();
	}

	public static SceneManager getInstance() {
		return Singleton.INSTANCE;
	}

	private SceneManager() {
		super(null);	
		
		group.register(this);
	}
	
	private DefaultLoopGroup group = new DefaultLoopGroup(1);


	@Override
	protected void doRegister() {
		System.out.println("SceneManager.doRegister()" + Thread.currentThread().getId());

		
	}


	//两套方案：1）使用队列来处理。
	//2）直接处理
	@Override
	public void doAccept(ICommand command) {
		try{
			//2）
			command.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//运行这个任务来执行所有的场景命令  - 1）
	class SceneWorker implements Runnable{

		@Override
		public void run() {
			
		}		
	}
}
