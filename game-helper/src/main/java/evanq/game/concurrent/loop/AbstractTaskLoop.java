package evanq.game.concurrent.loop;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

import org.logicalcobwebs.concurrent.LinkedQueue;

import evanq.game.concurrent.EventExecutorGroup;

public abstract class AbstractTaskLoop extends SingleThreadLoop {
	
	private Queue<ITask> tasksInLooping;
	
	
	protected AbstractTaskLoop(EventExecutorGroup parent,
			ThreadFactory threadFactory, boolean addTaskWakesUp) {
		super(parent, threadFactory, addTaskWakesUp);
	}

	protected Queue<ITask> newLoopQueue() {
		return new LinkedBlockingQueue<ITask>();
	}
	
	
	@Override
	public ITaskFuture register(ITask task) {
		//将任务注册进入线程中

		if (task == null) {
			throw new NullPointerException("task");
		}
		
		ITaskPromise newTaskPromise = task.newTaskPromise();
		task.register(this, newTaskPromise);
		
		//需要注册一个任务，来清理过期任务
		
		tasksInLooping.add((AbstractTask)task);
		
		return newTaskPromise;
	}
	
	
	@Override
	public List<Runnable> shutdownNow() {
		throw new UnsupportedOperationException(
				"DefaultLoop.shutdownNow()");
	}

	
	protected abstract void loopTasks();
	
	@Override
	protected void run() {
	
		if(null == tasksInLooping){
			tasksInLooping = newLoopQueue();
		}
		
		for (;;) {
			
			//if has task
			//run task
			//else perform movement.
			Runnable task = takeTask();
			if (task != null) {
				task.run();
				updateLastExecutionTime();			
			}
			
			loopTasks();
			
			if (confirmShutdown()) {
				break;
			}

		}
		
	}
}
