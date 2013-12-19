package evanq.game.concurrent.loop;


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
	
	ITask parent();
	
	ITaskWorkFlow workflow();
			
	public void accept(ICommand cmd);
	
	public void register(ILoop loop, ITaskPromise promise);
		
	public void close(ILoop loop, ITaskPromise promise);
	
}
