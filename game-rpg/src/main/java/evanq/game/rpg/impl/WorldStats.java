package evanq.game.rpg.impl;

/**
 * 
 * 游戏世界统计线程
 * 
 * 
 * @author Evan
 *
 */
public class WorldStats implements Runnable {

	
	//对象数
	
	//战场数
	
	//内存数
	
	//经济数
	
	
	@Override
	public synchronized void run() {
		
		while(true){
			
			stat();
			
			persistenceReport();
			
			try {
				wait(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//return a report
	private void stat(){
		
	}
	
	//持久化统计报告
	private void persistenceReport(){
		
	}
	
}
