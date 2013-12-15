package evanq.game.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * Abstract {@link Future} implementation which does not allow for cancellation.
 * 
 * @author Evan cppmain@gmail.com
 *
 * @param <V>
 */
public abstract class AbstractFuture<V> implements Future<V> {
  
	@Override
    public V get() throws InterruptedException, ExecutionException {
        await();

        //执行中发生的异常，包装后抛出
        Throwable cause = cause();
        if (cause == null) {
            return getNow();
        }
        throw new ExecutionException(cause);
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (await(timeout, unit)) {
            Throwable cause = cause();
            if (cause == null) {
                return getNow();
            }
            throw new ExecutionException(cause);
        }
        throw new TimeoutException();
    }


}
