package evanq.game.concurrentclient;

import evanq.game.concurrent.loop.AbstractTask;
import evanq.game.concurrent.loop.DefaultLoopGroup;
import evanq.game.concurrent.loop.ITask;

public class SingleThreadLoopTest {

	static class SimpleTask extends AbstractTask {

		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		DefaultLoopGroup group = new DefaultLoopGroup(1);
		
		ITask task = new SimpleTask();
		
		group.register(task);
		
		Object lock = new Object();
		synchronized (lock) {
			lock.wait();
		}
	}

}
