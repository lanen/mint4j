package evanq.game.concurrent.loop;

import evanq.game.concurrent.Future;
import evanq.game.concurrent.GenericFutureListener;
import evanq.game.concurrent.Promise;

/**
 * 
 * {@link ITask} 提交给线程执行，异步返回的结果
 *  
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface ITaskFuture extends Future<Void>,Promise<Void> {

	ITask task();

    @Override
    ITaskFuture addListener(GenericFutureListener<? extends Future<? super Void>> listener);

    @Override
    ITaskFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... listeners);

    @Override
    ITaskFuture removeListener(GenericFutureListener<? extends Future<? super Void>> listener);

    @Override
    ITaskFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... listeners);

    @Override
    ITaskFuture sync() throws InterruptedException;

    @Override
    ITaskFuture syncUninterruptibly();

    @Override
    ITaskFuture await() throws InterruptedException;

    @Override
    ITaskFuture awaitUninterruptibly();
}
