package evanq.game.concurrent.loop;

import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;

public abstract class AbstractTask implements ITask {
    
	private static final Trace logger = LogSystem.getDefaultTrace(AbstractTask.class);

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
		return workflow;
	}

	protected abstract void doRegister();
//	protected abstract void doActive();
//	protected abstract void doDeRegister();
//	protected abstract void doDeActive();
//	protected abstract void doOpen();
//	
	public boolean isRegistered() {
		return registered;
	}

	
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
                 logger.error(
                         "Force-closing a channel whose registration task was not accepted by an event loop: {}",
                          t);               
                 promise.setFailure(t);
             }
         }
	}
	
	protected abstract void doAccept(ICommand command);
	
	@Override
	public void accept(final ICommand command) {
		if (null == command) {
			throw new NullPointerException("command");
		}

        if (eventLoop.inEventLoop()) {
        	doAccept(command);
        } else {
        	eventLoop.execute(new Runnable() {
        		@Override
        		public void run() {
        			doAccept(command);
        		}
        	}); 
        }		
	}

	@Override
	public void close(ILoop loop, ITaskPromise promise) {
		
	}
	

	private void register0(ITaskPromise promise) {
		try {
			doRegister();
			registered = true;
			promise.setSuccess();
			workflow.fireRegistered();
			workflow.fireActived();
			
		} catch (Throwable t) {

			if (!promise.tryFailure(t)) {
				logger.error(
						"Tried to fail the registration promise, but it is complete already. "
								+ "Swallowing the cause of the registration failure:{}",
						t);
			}
		}
		   
	}
}
