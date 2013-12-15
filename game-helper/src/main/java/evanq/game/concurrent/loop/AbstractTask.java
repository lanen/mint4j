package evanq.game.concurrent.loop;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 * 
 */
public abstract class AbstractTask implements ITask {

	// 任务当前所在的循环[帧]里面
	private volatile ILoop loop;
	// 任务是否被注册了
	private volatile boolean registered;

	protected AbstractTask() {
	}

	@Override
	public ITaskPromise newTaskPromise() {
		return new DefaultTaskPromise(this);
	}

	@Override
	public ILoop currentLoop() {
		return loop;
	}

	@Override
	public boolean isRegistered() {
		return registered;
	}

	public final void register(ILoop loop, final ITaskPromise promise) {
		if (null == loop) {
			throw new NullPointerException("loop");
		}

		if (null == promise) {
			throw new NullPointerException("promise");
		}
		
		if (isRegistered()) {
			promise.setFailure(new IllegalStateException(
					"registered to an event loop already"));
			return;
		}
		
		this.loop = loop;
		if(this.loop.inEventLoop()){
			//
			register0(promise);
		}else{
			//进入此方法是线程不是当前循环所在线程
			this.loop.execute(new Runnable() {
				
				@Override
				public void run() {
					register0(promise);
				}
			});
		}

	}
	
	
	private void register0(ITaskPromise promise){		
		this.registered=true;
        promise.setSuccess();
        //fire task register event
        System.out.println("注册成功");
        //if active , fire task active
        System.out.println("激活成功");
        
	}
	
   protected final boolean ensureOpen(ITaskFuture promise) {
       return true;
   }

}
