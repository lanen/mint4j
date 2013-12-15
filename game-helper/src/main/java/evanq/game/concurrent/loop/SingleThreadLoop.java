package evanq.game.concurrent.loop;

import java.util.concurrent.ThreadFactory;

import evanq.game.concurrent.EventExecutorGroup;
import evanq.game.concurrent.ScheduledFuture;
import evanq.game.concurrent.SingleThreadEventExecutor;

/**
 * 
 * 单线程业务循环
 * 
 * @author Evan cppmain@gmail.com
 * 
 */
public abstract class SingleThreadLoop extends SingleThreadEventExecutor
		implements ILoop {

	protected SingleThreadLoop(EventExecutorGroup parent,
			ThreadFactory threadFactory, boolean addTaskWakesUp) {
		super(parent, threadFactory, addTaskWakesUp);
	}

	@Override
	public ILoopGroup parent() {
		return (ILoopGroup) super.parent();
	}

	@Override
	public ILoop next() {
		return (ILoop) super.next();
	}

	@Override
	public ITaskFuture register(ITask task) {
		//将任务注册进入线程中
		
		if (task == null) {
			throw new NullPointerException("task");
		}
		return register(task,);
	}

	@Override
	public ITaskFuture register(ITask task, long nanaTime, long period) {
		
		ITaskPromise newTaskPromise = task.newTaskPromise();
		task.register(this, newTaskPromise);
		
		return null;
	}
	
	
	
	
}
