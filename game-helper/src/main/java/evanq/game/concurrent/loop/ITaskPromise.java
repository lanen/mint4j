package evanq.game.concurrent.loop;

import evanq.game.concurrent.Future;
import evanq.game.concurrent.GenericFutureListener;
import evanq.game.concurrent.Promise;

/**
 * 
 * A {@link Promise} 是一个特殊化的{@link Future}
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface ITaskPromise extends ITaskFuture, Promise<Void> {
	
	ITask task();
	
	@Override
	ITaskPromise setSuccess(Void result);

	ITaskPromise setSuccess();

	boolean trySuccess();

	@Override
	ITaskPromise setFailure(Throwable cause);

	@Override
	ITaskPromise addListener(
			GenericFutureListener<? extends Future<? super Void>> listener);

	@Override
	ITaskPromise addListeners(
			GenericFutureListener<? extends Future<? super Void>>... listeners);

	@Override
	ITaskPromise removeListener(
			GenericFutureListener<? extends Future<? super Void>> listener);

	@Override
	ITaskPromise removeListeners(
			GenericFutureListener<? extends Future<? super Void>>... listeners);

	@Override
	ITaskPromise sync() throws InterruptedException;

	@Override
	ITaskPromise syncUninterruptibly();

	@Override
	ITaskPromise await() throws InterruptedException;

	@Override
	ITaskPromise awaitUninterruptibly();

}
