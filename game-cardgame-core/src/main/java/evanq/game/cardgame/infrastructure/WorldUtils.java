package evanq.game.cardgame.infrastructure;

import com.artemis.World;

import evanq.game.cardgame.infrastructure.es.services.ServiceManager;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class WorldUtils {
	
	//记录了类初始化的时间
	private static final long START_TIME = System.nanoTime();

	static long nanoTime() {
		//返回运行的时间
		return System.nanoTime() - START_TIME;
	}
	
	//到期时间
	static long deadlineNanos(long delay) {
		return nanoTime() + delay;
	}

}
