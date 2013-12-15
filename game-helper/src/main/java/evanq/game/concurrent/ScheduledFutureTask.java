package evanq.game.concurrent;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ScheduledFutureTask<V> extends PromiseTask<V> implements
		ScheduledFuture<V> {
	
	//
	private static final AtomicLong nextTaskId = new AtomicLong();
	
	//记录了类初始化的时间
	private static final long START_TIME = System.nanoTime();

	static long nanoTime() {
		//返回运行的时间
		return System.nanoTime() - START_TIME;
	}
	
	//到期时间
	static long deadlineNanos(long delay) {
		return nanoTime() + delay;
	}

	//任务编号
	private final long id = nextTaskId.getAndIncrement();
	
	//任务队列
	private final Queue<ScheduledFutureTask<?>> delayedTaskQueue;
	
	//到达下一个任务的执行时间
	private long deadlineNanos;
	
	/* 0 - no repeat, >0 - repeat at fixed rate, <0 - repeat with fixed delay */
	private final long periodNanos;

	ScheduledFutureTask(EventExecutor executor,
			Queue<ScheduledFutureTask<?>> delayedTaskQueue, Runnable runnable,
			V result, long nanoTime) {

		this(executor, delayedTaskQueue, toCallable(runnable, result), nanoTime);
	}

	ScheduledFutureTask(EventExecutor executor,
			Queue<ScheduledFutureTask<?>> delayedTaskQueue,
			Callable<V> callable, long nanoTime, long period) {

		super(executor, callable);
		if (period == 0) {
			throw new IllegalArgumentException("period: 0 (expected: != 0)");
		}
		this.delayedTaskQueue = delayedTaskQueue;
		deadlineNanos = nanoTime;
		periodNanos = period;
	}

	ScheduledFutureTask(EventExecutor executor,
			Queue<ScheduledFutureTask<?>> delayedTaskQueue,
			Callable<V> callable, long nanoTime) {

		super(executor, callable);
		this.delayedTaskQueue = delayedTaskQueue;
		deadlineNanos = nanoTime;
		periodNanos = 0;
	}

	@Override
	protected EventExecutor executor() {
		return super.executor();
	}

	public long deadlineNanos() {
		return deadlineNanos;
	}

	public long delayNanos() {
		return Math.max(0, deadlineNanos() - nanoTime());
	}

	public long delayNanos(long currentTimeNanos) {
		return Math.max(0, deadlineNanos() - (currentTimeNanos - START_TIME));
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(delayNanos(), TimeUnit.NANOSECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		if (this == o) {
			return 0;
		}

		//两者时间差，排序
		ScheduledFutureTask<?> that = (ScheduledFutureTask<?>) o;
		long d = deadlineNanos() - that.deadlineNanos();
		if (d < 0) {
			return -1;
		} else if (d > 0) {
			return 1;
		} else if (id < that.id) {
			return -1;
		} else if (id == that.id) {
			throw new Error();
		} else {
			return 1;
		}
	}

	@Override
	public void run() {
		assert executor().inEventLoop();
		try {
			if (periodNanos == 0) {
				if (setUncancellableInternal()) {
					V result = task.call();
					setSuccessInternal(result);
				}
			} else {
				// check if is done as it may was cancelled
				if (!isCancelled()) {
					task.call();
					if (!executor().isShutdown()) {
						long p = periodNanos;
						if (p > 0) {
							//在指定时间后面开始
							deadlineNanos += p;
						} else {
							//p < 0 ,当前时间+Math.abs(p)
							deadlineNanos = nanoTime() - p;
						}
						if (!isCancelled()) {
							delayedTaskQueue.add(this);
						}
					}
				}
			}
		} catch (Throwable cause) {
			setFailureInternal(cause);
		}
	}

	@Override
	protected StringBuilder toStringBuilder() {
		StringBuilder buf = super.toStringBuilder();
		buf.setCharAt(buf.length() - 1, ',');
		buf.append(" id: ");
		buf.append(id);
		buf.append(", deadline: ");
		buf.append(deadlineNanos);
		buf.append(", period: ");
		buf.append(periodNanos);
		buf.append(')');
		return buf;
	}

}
