package evanq.game.concurrent.loop;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DefaultTaskWorkFlow implements ITaskWorkFlow {
	
	private AbstractTask task;
	
	public DefaultTaskWorkFlow(AbstractTask task) {
		this.task = task;
	}
	
	@Override
	public ITask task() {
		return this.task;
	}

	@Override
	public void fireRegistered() {
		System.out.println("DefaultTaskWorkFlow.fireRegistered()");
	}

	@Override
	public void fireActived() {
		System.out.println("DefaultTaskWorkFlow.fireActived()");
	}

	@Override
	public void fireDeActived() {
		System.out.println("DefaultTaskWorkFlow.fireDeActived()");
	
	}

	@Override
	public void fireDeRegistered() {

		System.out.println("DefaultTaskWorkFlow.fireDeRegistered()");
	}

	@Override
	public void fireMovement() {
		System.out.println("DefaultTaskWorkFlow.fireMovement()");
	}

	@Override
	public void fireException(Throwable cause) {
		System.out.println("DefaultTaskWorkFlow.fireException()");
	}

}
