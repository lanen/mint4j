package evanq.game.concurrent.loop;

import java.util.List;
import java.util.concurrent.ThreadFactory;

import evanq.game.concurrent.EventExecutorGroup;

/**
 * @author Evan cppmain@gmail.com
 * 
 */
public class DefaultLoop extends SingleThreadLoop {

	public DefaultLoop(EventExecutorGroup parent, ThreadFactory threadFactory) {
		super(parent, threadFactory, true);
	}

	@Override
	public List<Runnable> shutdownNow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void run() {
		for (;;) {
			Runnable task = takeTask();
			if (task != null) {
				System.out.println("Running Task");
				task.run();
				updateLastExecutionTime();
			}

			if (confirmShutdown()) {
				break;
			}

		}
	}

}
