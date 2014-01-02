package evanq.game.concurrent.loop;

import java.util.List;
import java.util.concurrent.ThreadFactory;

import evanq.game.concurrent.EventExecutorGroup;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 * 
 */
public class DefaultLoop extends SingleThreadLoop {

	public DefaultLoop(EventExecutorGroup parent, ThreadFactory threadFactory) {
		super(parent, threadFactory, true);
	}

	@Override
	public List<Runnable> shutdownNow() {
		throw new UnsupportedOperationException(
				"DefaultLoop.shutdownNow()");
	}

	@Override
	protected void run() {
		
		for (;;) {
			
			//if has task
			//run task
			//else perform movement.
			Runnable task = takeTask();
			if (task != null) {
//				System.out.println("Running Task  "+ Thread.currentThread());
				task.run();
				updateLastExecutionTime();			
			}
			
			if (confirmShutdown()) {
				break;
			}

		}
		
	}
	
}
