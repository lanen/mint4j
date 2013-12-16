package evanq.game.concurrent.loop;

/**
 * 
 * 任务流程
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface ITaskWorkFlow {

	ITask task();
	
	void fireRegistered();
	
	void fireActived();
	
	void fireDeActived();
	
	void fireDeRegistered();
	
	void fireMovement();
	
	void fireException(Throwable cause);
	
}
