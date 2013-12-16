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
	
	/**
	 * 当前任务被注册到线程队列中
	 * @return
	 */
	boolean isRegistered();
	
	boolean isActived();
	
	boolean isOpen();
	
	boolean isDeActived();
	
	boolean isDeRegistered();
	
	
	public void register(ILoop loop, ITaskPromise promise);
	
}
