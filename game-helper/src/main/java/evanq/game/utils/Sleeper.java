package evanq.game.utils;

/**
 * A thread sleep. on  current Thread
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class Sleeper {

	private static final Object lock = new Object();
	private static boolean isLock = false;
	
	public static void sleep(long ms){
		if(isSleeping())return;
		if(ms<=0){
			sleep();
			return;
		}
		synchronized (lock) {
			isLock = true;
			try {
				lock.wait(ms);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void sleep(){
		if(isSleeping())return;
		
		synchronized (lock) {
			
			isLock = true;
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isSleeping(){
		return isLock;
	}
	
	public static void wakeup(){
		lock.notify();
		isLock = false;
	}
}
