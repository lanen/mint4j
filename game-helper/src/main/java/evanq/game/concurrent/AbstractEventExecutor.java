package evanq.game.concurrent;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 为{@link EventExecutor} 提供基础实现
 * 
 * 查看JDK 版本的 {@link AbstractExecutorService} 获取更多的理解。
 * 
 * 继承这个类实现<i>单线程</i>或<i>线程池</i>的任务执行器。
 * 
 * @author Evan cppmain@gmail.com
 * 
 */
public abstract class AbstractEventExecutor extends AbstractExecutorService
		implements EventExecutor {

	@Override
	public EventExecutor next() {
		return this;
	}

	@Override
	public boolean inEventLoop() {
		return inEventLoop(Thread.currentThread());
	}

	@Override
	public Iterator<EventExecutor> iterator() {
		return new EventExecutorIterator();
	}

	@Override
	public Future<?> shutdownGracefully() {
		//TODO 2秒的静止反应时间，15秒的关闭超时时间
		return shutdownGracefully(2, 15, TimeUnit.SECONDS);
	}

	@Override
	public <V> Promise<V> newPromise() {
		return new DefaultPromise<V>(this);
	}


	@Override
	public <V> Future<V> newSucceededFuture(V result) {
		return new SucceededFuture<V>(this, result);
	}

	@Override
	public <V> Future<V> newFailedFuture(Throwable cause) {
		return new FailedFuture<V>(this, cause);
	}

	@Override
	public Future<?> submit(Runnable task) {
		return (Future<?>) super.submit(task);
	}

	@Override
	public <T> Future<T> submit(Runnable task, T result) {
		return (Future<T>) super.submit(task, result);
	}

	@Override
	public <T> Future<T> submit(Callable<T> task) {
		return (Future<T>) super.submit(task);
	}

    /**
     * @deprecated {@link #shutdownGracefully(long, long, TimeUnit)} or {@link #shutdownGracefully()} instead.
     */
    @Override
    @Deprecated
    public abstract void shutdown();

    /**
     * @deprecated {@link #shutdownGracefully(long, long, TimeUnit)} or {@link #shutdownGracefully()} instead.
     */
    @Override
    @Deprecated
    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }
    
	@Override
	protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
		return new PromiseTask<T>(this, runnable, value);
	}

	@Override
	protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
		return new PromiseTask<T>(this, callable);
	}

	@Override
	public ScheduledFuture<?> schedule(Runnable command, long delay,
			TimeUnit unit) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay,
			TimeUnit unit) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
			long initialDelay, long period, TimeUnit unit) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
			long initialDelay, long delay, TimeUnit unit) {
		throw new UnsupportedOperationException();
	}

	private final class EventExecutorIterator implements
			Iterator<EventExecutor> {
		private boolean nextCalled;

		@Override
		public boolean hasNext() {
			return !nextCalled;
		}

		@Override
		public EventExecutor next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			nextCalled = true;
			return AbstractEventExecutor.this;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("read-only");
		}
	}

}
