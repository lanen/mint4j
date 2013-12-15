package evanq.game.concurrent.loop;


import evanq.game.concurrent.DefaultPromise;
import evanq.game.concurrent.EventExecutor;
import evanq.game.concurrent.Future;
import evanq.game.concurrent.GenericFutureListener;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DefaultTaskPromise extends DefaultPromise<Void> implements ITaskPromise {

	private ITask task;
	
	public DefaultTaskPromise(ITask task) {
		this.task = task;
	}
	
	public DefaultTaskPromise(ITask task, EventExecutor executor) {
		super(executor);
		this.task = task;
	}
    @Override
    protected EventExecutor executor() {
        EventExecutor e = super.executor();
        if (e == null) {
            return task().currentLoop();
        } else {
            return e;
        }
    }

    @Override
    public ITask task() {
        return this.task;
    }

    @Override
    public ITaskPromise setSuccess() {
        return setSuccess(null);
    }

    @Override
    public ITaskPromise setSuccess(Void result) {
        super.setSuccess(result);
        return this;
    }

    @Override
    public boolean trySuccess() {
        return trySuccess(null);
    }

    @Override
    public ITaskPromise setFailure(Throwable cause) {
        super.setFailure(cause);
        return this;
    }

    @Override
    public ITaskPromise addListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        super.addListener(listener);
        return this;
    }

    @Override
    public ITaskPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        super.addListeners(listeners);
        return this;
    }

    @Override
    public ITaskPromise removeListener(GenericFutureListener<? extends Future<? super Void>> listener) {
        super.removeListener(listener);
        return this;
    }

    @Override
    public ITaskPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... listeners) {
        super.removeListeners(listeners);
        return this;
    }

    @Override
    public ITaskPromise sync() throws InterruptedException {
        super.sync();
        return this;
    }

    @Override
    public ITaskPromise syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }

    @Override
    public ITaskPromise await() throws InterruptedException {
        super.await();
        return this;
    }

    @Override
    public ITaskPromise awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }
    
}
