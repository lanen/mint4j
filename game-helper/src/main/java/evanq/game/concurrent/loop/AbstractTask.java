package evanq.game.concurrent.loop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTask implements ITask {
    
    private static final Logger logger = LoggerFactory.getLogger(AbstractTask.class);

//    private final ITaskFuture succeededFuture = new SucceededChannelFuture(this, null);
//    private final VoidChannelPromise voidPromise = new VoidChannelPromise(this, true);
//    private final VoidChannelPromise unsafeVoidPromise = new VoidChannelPromise(this, false);
//    private final CloseFuture closeFuture = new CloseFuture(this);

    private ITask parent;
    
    private DefaultTaskWorkFlow workflow;
    
    private volatile ILoop eventLoop;
    private volatile boolean registered;
    
    protected AbstractTask(ITask parent) {
    	this.parent=parent;
    	this.workflow = new DefaultTaskWorkFlow(this);
	}
    
	@Override
	public ITaskPromise newTaskPromise() {
		return new DefaultTaskPromise(this);
	}

	@Override
	public ILoop currentLoop() {
		return this.eventLoop;
	}
	
	@Override
	public ITask parent() {
		return parent;
	}

	@Override
	public ITaskWorkFlow workflow() {
		return null;
	}

	protected abstract void doRegister();
	protected abstract void doActive();
	protected abstract void doDeRegister();
	protected abstract void doDeActive();
	protected abstract void doOpen();
	
	
	@Override
	public boolean isRegistered() {
		return registered;
	}

	protected abstract void run() ;
	
	@Override
	public void register(ILoop loop, final ITaskPromise promise) {
		
		if (null == loop) {
			throw new NullPointerException("loop");
		}
		if (null == promise) {
			throw new NullPointerException("promise");			
		}
		
	     if (isRegistered()) {
             promise.setFailure(new IllegalStateException("registered to an event loop already"));
             return;
         }
        

         this.eventLoop = loop;

         if (eventLoop.inEventLoop()) {
             register0(promise);
         } else {
             try {
                 eventLoop.execute(new Runnable() {
                     @Override
                     public void run() {
                         register0(promise);
                     }
                 });
             } catch (Throwable t) {
                 logger.warn(
                         "Force-closing a channel whose registration task was not accepted by an event loop: {}",
                         AbstractTask.this, t);               
                 promise.setFailure(t);
             }
         }
	}
	
	
	private void register0(ITaskPromise promise) {
		try {
			doRegister();
			registered = true;
			promise.setSuccess();
			workflow.fireRegistered();
			if (isActived()) {
				workflow.fireActived();
			}
		} catch (Throwable t) {

			if (!promise.tryFailure(t)) {
				logger.warn(
						"Tried to fail the registration promise, but it is complete already. "
								+ "Swallowing the cause of the registration failure:",
						t);
			}
		}
		   
	}
}
