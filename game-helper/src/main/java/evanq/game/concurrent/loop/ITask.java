package evanq.game.concurrent.loop;

import evanq.game.concurrent.ScheduledFutureTask;

/**
 * 
 * 提交给线程执行的任务
 * 
 * 任务的状态：
 * <br/>
 * 
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface ITask {

	
	/**
	 * 
	 * 建立一个当前任务的执行结果
	 * 
	 * @return
	 */
	public ITaskPromise newTaskPromise();
	
	/**
	 * @return
	 */
	public ILoop currentLoop();
	
	/**
	 * Return <i>true</i> if this task is register to a loop
	 * otherwise <i>false</i>
	 * @return
	 */
	public boolean isRegistered();
	
	public void register(ILoop loop, ITaskPromise promise);
	
}
