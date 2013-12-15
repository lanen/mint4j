package evanq.game.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 单线程执行提交上来的所有任务
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class SingleThreadEventExecutor extends AbstractEventExecutor {
	
	private static final Logger logger = LoggerFactory.getLogger(SingleThreadEventExecutor.class);
	
	//线程的5个状态
	private static final int ST_NOT_STARTED = 1;
	private static final int ST_STARTED = 2;
	private static final int ST_SHUTTING_DOWN = 3;
	private static final int ST_SHUTDOWN = 4;
	private static final int ST_TERMINATED = 5;

	//唤醒线程的任务
	private static final Runnable WAKEUP_TASK = new Runnable() {
		@Override
		public void run() {
			// Do nothing.
		}
	};

	//父线程
	private final EventExecutorGroup parent;
	
	//任务队列
	private final Queue<Runnable> taskQueue;
	
	//延迟执行的任务队列
	final Queue<ScheduledFutureTask<?>> delayedTaskQueue = new PriorityQueue<ScheduledFutureTask<?>>();

	//执行器线程
	private final Thread thread;
	
	//线程状态锁
	private final Object stateLock = new Object();
	
	//信号灯
	private final Semaphore threadLock = new Semaphore(0);
	
	//关闭线程时候，挂载的任务
	private final Set<Runnable> shutdownHooks = new LinkedHashSet<Runnable>();
	
	//开关：增加任务时是否唤醒线程
	private final boolean addTaskWakesUp;
	
	//上一次的线程时间
	private long lastExecutionTime;
	
	//线程状态
	private volatile int state = ST_NOT_STARTED;
	
	private volatile long gracefulShutdownQuietPeriod;
	private volatile long gracefulShutdownTimeout;
	
	//进入关闭状态的时间戳
	private long gracefulShutdownStartTime;

	
	private final Promise<?> terminationFuture = new DefaultPromise<Void>(GlobalEventExecutor.INSTANCE);

	/**
	 * Create a new instance
	 * 
	 * @param parent
	 *            the {@link EventExecutorGroup} which is the parent of this
	 *            instance and belongs to it
	 * @param threadFactory
	 *            the {@link ThreadFactory} which will be used for the used
	 *            {@link Thread}
	 * @param addTaskWakesUp
	 *            {@code true} if and only if invocation of
	 *            {@link #addTask(Runnable)} will wake up the executor thread
	 */
	protected SingleThreadEventExecutor(EventExecutorGroup parent,
			ThreadFactory threadFactory, boolean addTaskWakesUp) {

		if (threadFactory == null) {
			throw new NullPointerException("threadFactory");
		}

		this.parent = parent;
		this.addTaskWakesUp = addTaskWakesUp;

		thread = threadFactory.newThread(new Runnable() {
			@Override
			public void run() {
				boolean success = false;
				updateLastExecutionTime();
				try {
					SingleThreadEventExecutor.this.run();
					success = true;
				} catch (Throwable t) {
					logger.warn(
							"Unexpected exception from an event executor: ", t);
				} finally {
					if (state < ST_SHUTTING_DOWN) {
						state = ST_SHUTTING_DOWN;
					}

					// Check if confirmShutdown() was called at the end of the
					// loop.
					if (success && gracefulShutdownStartTime == 0) {
						logger.error("Buggy "
								+ EventExecutor.class.getSimpleName()
								+ " implementation; "
								+ SingleThreadEventExecutor.class
										.getSimpleName()
								+ ".confirmShutdown() must be called "
								+ "before run() implementation terminates.");
					}

					try {
						// Run all remaining tasks and shutdown hooks.
						for (;;) {
							if (confirmShutdown()) {
								break;
							}
						}
					} finally {
						try {
							cleanup();
						} finally {
							synchronized (stateLock) {
								state = ST_TERMINATED;
							}
							threadLock.release();
							if (!taskQueue.isEmpty()) {
								logger.warn("An event executor terminated with "
										+ "non-empty task queue ("
										+ taskQueue.size() + ')');
							}

							terminationFuture.setSuccess(null);
						}
					}
				}
			}
		});

		taskQueue = newTaskQueue();
	}

	/**
	 * Create a new {@link Queue} which will holds the tasks to execute. This
	 * default implementation will return a {@link LinkedBlockingQueue} but if
	 * your sub-class of {@link SingleThreadEventExecutor} will not do any
	 * blocking calls on the this {@link Queue} it may make sense to
	 * {@code @Override} this and return some more performant implementation
	 * that does not support blocking operations at all.
	 */
	protected Queue<Runnable> newTaskQueue() {
		return new LinkedBlockingQueue<Runnable>();
	}

	@Override
	public EventExecutorGroup parent() {
		return parent;
	}

	/**
	 * Interrupt the current running {@link Thread}.
	 */
	protected void interruptThread() {
		thread.interrupt();
	}

	/**
	 * @see {@link Queue#poll()}
	 */
	protected Runnable pollTask() {
		assert inEventLoop();
		for (;;) {
			Runnable task = taskQueue.poll();
			if (task == WAKEUP_TASK) {
				continue;
			}
			return task;
		}
	}

	/**
	 * Take the next {@link Runnable} from the task queue and so will block if
	 * no task is currently present.
	 * <p>
	 * Be aware that this method will throw an
	 * {@link UnsupportedOperationException} if the task queue, which was
	 * created via {@link #newTaskQueue()}, does not implement
	 * {@link BlockingQueue}.
	 * </p>
	 * 
	 * @return {@code null} if the executor thread has been interrupted or waken
	 *         up.
	 */
	protected Runnable takeTask() {
		assert inEventLoop();
		if (!(taskQueue instanceof BlockingQueue)) {
			throw new UnsupportedOperationException();
		}

		BlockingQueue<Runnable> taskQueue = (BlockingQueue<Runnable>) this.taskQueue;
		for (;;) {
			ScheduledFutureTask<?> delayedTask = delayedTaskQueue.peek();
			if (delayedTask == null) {
				Runnable task = null;
				try {
					task = taskQueue.take();
					if (task == WAKEUP_TASK) {
						task = null;
					}
				} catch (InterruptedException e) {
					// Ignore
				}
				return task;
			} else {
				long delayNanos = delayedTask.delayNanos();
				Runnable task = null;
				if (delayNanos > 0) {
					try {
						task = taskQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
					} catch (InterruptedException e) {
						return null;
					}
				}
				if (task == null) {
					// We need to fetch the delayed tasks now as otherwise there
					// may be a chance that
					// delayed tasks are never executed if there is always one
					// task in the taskQueue.
					// This is for example true for the read task of OIO
					// Transport
					// See https://github.com/netty/netty/issues/1614
					fetchFromDelayedQueue();
					task = taskQueue.poll();
				}

				if (task != null) {
					return task;
				}
			}
		}
	}

	private void fetchFromDelayedQueue() {
		long nanoTime = 0L;
		for (;;) {
			ScheduledFutureTask<?> delayedTask = delayedTaskQueue.peek();
			if (delayedTask == null) {
				break;
			}

			if (nanoTime == 0L) {
				nanoTime = ScheduledFutureTask.nanoTime();
			}

			if (delayedTask.deadlineNanos() <= nanoTime) {
				delayedTaskQueue.remove();
				taskQueue.add(delayedTask);
			} else {
				break;
			}
		}
	}

	/**
	 * @see {@link Queue#peek()}
	 */
	protected Runnable peekTask() {
		assert inEventLoop();
		return taskQueue.peek();
	}

	/**
	 * @see {@link Queue#isEmpty()}
	 */
	protected boolean hasTasks() {
		assert inEventLoop();
		return !taskQueue.isEmpty();
	}

	/**
	 * Return the number of tasks that are pending for processing.
	 * 
	 * <strong>Be aware that this operation may be expensive as it depends on
	 * the internal implementation of the SingleThreadEventExecutor. So use it
	 * was care!</strong>
	 */
	public final int pendingTasks() {
		return taskQueue.size();
	}

	/**
	 * Add a task to the task queue, or throws a
	 * {@link RejectedExecutionException} if this instance was shutdown before.
	 */
	protected void addTask(Runnable task) {
		if (task == null) {
			throw new NullPointerException("task");
		}
		if (isShutdown()) {
			reject();
		}
		taskQueue.add(task);
	}

	/**
	 * @see {@link Queue#remove(Object)}
	 */
	protected boolean removeTask(Runnable task) {
		if (task == null) {
			throw new NullPointerException("task");
		}
		return taskQueue.remove(task);
	}

	/**
	 * Poll all tasks from the task queue and run them via
	 * {@link Runnable#run()} method.
	 * 
	 * @return {@code true} if and only if at least one task was run
	 */
	protected boolean runAllTasks() {
		fetchFromDelayedQueue();
		Runnable task = pollTask();
		if (task == null) {
			return false;
		}

		for (;;) {
			try {
				task.run();
			} catch (Throwable t) {
				logger.warn("A task raised an exception.", t);
			}

			task = pollTask();
			if (task == null) {
				lastExecutionTime = ScheduledFutureTask.nanoTime();
				return true;
			}
		}
	}

	/**
	 * Poll all tasks from the task queue and run them via
	 * {@link Runnable#run()} method. This method stops running the tasks in the
	 * task queue and returns if it ran longer than {@code timeoutNanos}.
	 */
	protected boolean runAllTasks(long timeoutNanos) {
		fetchFromDelayedQueue();
		Runnable task = pollTask();
		if (task == null) {
			return false;
		}

		final long deadline = ScheduledFutureTask.nanoTime() + timeoutNanos;
		long runTasks = 0;
		long lastExecutionTime;
		for (;;) {
			try {
				task.run();
			} catch (Throwable t) {
				logger.warn("A task raised an exception.", t);
			}

			runTasks++;

			// Check timeout every 64 tasks because nanoTime() is relatively
			// expensive.
			// XXX: Hard-coded value - will make it configurable if it is really
			// a problem.
			if ((runTasks & 0x3F) == 0) {
				lastExecutionTime = ScheduledFutureTask.nanoTime();
				if (lastExecutionTime >= deadline) {
					break;
				}
			}

			task = pollTask();
			if (task == null) {
				lastExecutionTime = ScheduledFutureTask.nanoTime();
				break;
			}
		}

		this.lastExecutionTime = lastExecutionTime;
		return true;
	}

	/**
	 * Returns the amount of time left until the scheduled task with the closest
	 * dead line is executed.
	 */
	protected long delayNanos(long currentTimeNanos) {
		ScheduledFutureTask<?> delayedTask = delayedTaskQueue.peek();
		if (delayedTask == null) {
			return SCHEDULE_PURGE_INTERVAL;
		}

		return delayedTask.delayNanos(currentTimeNanos);
	}

	/**
	 * Updates the internal timestamp that tells when a submitted task was
	 * executed most recently. {@link #runAllTasks()} and
	 * {@link #runAllTasks(long)} updates this timestamp automatically, and thus
	 * there's usually no need to call this method. However, if you take the
	 * tasks manually using {@link #takeTask()} or {@link #pollTask()}, you have
	 * to call this method at the end of task execution loop for accurate quiet
	 * period checks.
	 */
	protected void updateLastExecutionTime() {
		lastExecutionTime = ScheduledFutureTask.nanoTime();
	}

	/**
	     *
	     */
	protected abstract void run();

	/**
	 * Do nothing, sub-classes may override
	 */
	protected void cleanup() {
		// NOOP
	}

	protected void wakeup(boolean inEventLoop) {
		if (!inEventLoop || state == ST_SHUTTING_DOWN) {
			taskQueue.add(WAKEUP_TASK);
		}
	}

	@Override
	public boolean inEventLoop(Thread thread) {
		return thread == this.thread;
	}

	/**
	 * Add a {@link Runnable} which will be executed on shutdown of this
	 * instance
	 */
	public void addShutdownHook(final Runnable task) {
		if (inEventLoop()) {
			shutdownHooks.add(task);
		} else {
			execute(new Runnable() {
				@Override
				public void run() {
					shutdownHooks.add(task);
				}
			});
		}
	}

	/**
	 * Remove a previous added {@link Runnable} as a shutdown hook
	 */
	public void removeShutdownHook(final Runnable task) {
		if (inEventLoop()) {
			shutdownHooks.remove(task);
		} else {
			execute(new Runnable() {
				@Override
				public void run() {
					shutdownHooks.remove(task);
				}
			});
		}
	}

	private boolean runShutdownHooks() {
		boolean ran = false;
		// Note shutdown hooks can add / remove shutdown hooks.
		while (!shutdownHooks.isEmpty()) {
			List<Runnable> copy = new ArrayList<Runnable>(shutdownHooks);
			shutdownHooks.clear();
			for (Runnable task : copy) {
				try {
					task.run();
				} catch (Throwable t) {
					logger.warn("Shutdown hook raised an exception.", t);
				} finally {
					ran = true;
				}
			}
		}

		if (ran) {
			lastExecutionTime = ScheduledFutureTask.nanoTime();
		}

		return ran;
	}

	@Override
	public Future<?> shutdownGracefully(long quietPeriod, long timeout,
			TimeUnit unit) {
		if (quietPeriod < 0) {
			throw new IllegalArgumentException("quietPeriod: " + quietPeriod
					+ " (expected >= 0)");
		}
		if (timeout < quietPeriod) {
			throw new IllegalArgumentException("timeout: " + timeout
					+ " (expected >= quietPeriod (" + quietPeriod + "))");
		}
		if (unit == null) {
			throw new NullPointerException("unit");
		}

		if (isShuttingDown()) {
			return terminationFuture();
		}

		boolean inEventLoop = inEventLoop();
		boolean wakeup = true;

		synchronized (stateLock) {
			if (isShuttingDown()) {
				return terminationFuture();
			}

			gracefulShutdownQuietPeriod = unit.toNanos(quietPeriod);
			gracefulShutdownTimeout = unit.toNanos(timeout);

			if (inEventLoop) {
				assert state == ST_STARTED;
				state = ST_SHUTTING_DOWN;
			} else {
				switch (state) {
				case ST_NOT_STARTED:
					state = ST_SHUTTING_DOWN;
					thread.start();
					break;
				case ST_STARTED:
					state = ST_SHUTTING_DOWN;
					break;
				default:
					wakeup = false;
				}
			}
		}

		if (wakeup) {
			wakeup(inEventLoop);
		}

		return terminationFuture();
	}

	@Override
	public Future<?> terminationFuture() {
		return terminationFuture;
	}

	@Override
	@Deprecated
	public void shutdown() {
		if (isShutdown()) {
			return;
		}

		boolean inEventLoop = inEventLoop();
		boolean wakeup = true;

		synchronized (stateLock) {
			if (isShutdown()) {
				return;
			}

			if (inEventLoop) {
				assert state == ST_STARTED || state == ST_SHUTTING_DOWN;
				state = ST_SHUTDOWN;
			} else {
				switch (state) {
				case ST_NOT_STARTED:
					state = ST_SHUTDOWN;
					thread.start();
					break;
				case ST_STARTED:
				case ST_SHUTTING_DOWN:
					state = ST_SHUTDOWN;
					break;
				default:
					wakeup = false;
				}
			}
		}

		if (wakeup) {
			wakeup(inEventLoop);
		}
	}

	@Override
	public boolean isShuttingDown() {
		return state >= ST_SHUTTING_DOWN;
	}

	@Override
	public boolean isShutdown() {
		return state >= ST_SHUTDOWN;
	}

	@Override
	public boolean isTerminated() {
		return state == ST_TERMINATED;
	}

	/**
	 * Confirm that the shutdown if the instance should be done now!
	 */
	protected boolean confirmShutdown() {
		if (!isShuttingDown()) {
			return false;
		}

		if (!inEventLoop()) {
			throw new IllegalStateException(
					"must be invoked from an event loop");
		}

		cancelDelayedTasks();

		if (gracefulShutdownStartTime == 0) {
			gracefulShutdownStartTime = ScheduledFutureTask.nanoTime();
		}

		if (runAllTasks() || runShutdownHooks()) {
			if (isShutdown()) {
				// Executor shut down - no new tasks anymore.
				return true;
			}

			// There were tasks in the queue. Wait a little bit more until no
			// tasks are queued for the quiet period.
			wakeup(true);
			return false;
		}

		final long nanoTime = ScheduledFutureTask.nanoTime();

		if (isShutdown()
				|| nanoTime - gracefulShutdownStartTime > gracefulShutdownTimeout) {
			return true;
		}

		if (nanoTime - lastExecutionTime <= gracefulShutdownQuietPeriod) {
			// Check if any tasks were added to the queue every 100ms.
			// TODO: Change the behavior of takeTask() so that it returns on
			// timeout.
			wakeup(true);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// Ignore
			}

			return false;
		}

		// No tasks were added for last quiet period - hopefully safe to shut
		// down.
		// (Hopefully because we really cannot make a guarantee that there will
		// be no execute() calls by a user.)
		return true;
	}

	private void cancelDelayedTasks() {
		if (delayedTaskQueue.isEmpty()) {
			return;
		}

		final ScheduledFutureTask<?>[] delayedTasks = delayedTaskQueue
				.toArray(new ScheduledFutureTask<?>[delayedTaskQueue.size()]);

		for (ScheduledFutureTask<?> task : delayedTasks) {
			task.cancel(false);
		}

		delayedTaskQueue.clear();
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit)
			throws InterruptedException {
		if (unit == null) {
			throw new NullPointerException("unit");
		}

		if (inEventLoop()) {
			throw new IllegalStateException(
					"cannot await termination of the current thread");
		}

		if (threadLock.tryAcquire(timeout, unit)) {
			threadLock.release();
		}

		return isTerminated();
	}

	@Override
	public void execute(Runnable task) {
		if (task == null) {
			throw new NullPointerException("task");
		}

		boolean inEventLoop = inEventLoop();
		if (inEventLoop) {
			addTask(task);
		} else {
			startThread();
			addTask(task);
			if (isShutdown() && removeTask(task)) {
				reject();
			}
		}

		if (!addTaskWakesUp) {
			wakeup(inEventLoop);
		}
	}

	protected static void reject() {
		throw new RejectedExecutionException("event executor terminated");
	}

	// ScheduledExecutorService implementation
	// 任务调度器的实现
	private static final long SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS
			.toNanos(1);

	@Override
	public ScheduledFuture<?> schedule(Runnable command, long delay,
			TimeUnit unit) {
		if (command == null) {
			throw new NullPointerException("command");
		}
		if (unit == null) {
			throw new NullPointerException("unit");
		}
		if (delay < 0) {
			throw new IllegalArgumentException(String.format(
					"delay: %d (expected: >= 0)", delay));
		}
		return schedule(new ScheduledFutureTask<Void>(this, delayedTaskQueue,
				command, null, ScheduledFutureTask.deadlineNanos(unit
						.toNanos(delay))));
	}

	@Override
	public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay,
			TimeUnit unit) {
		if (callable == null) {
			throw new NullPointerException("callable");
		}
		if (unit == null) {
			throw new NullPointerException("unit");
		}
		if (delay < 0) {
			throw new IllegalArgumentException(String.format(
					"delay: %d (expected: >= 0)", delay));
		}
		return schedule(new ScheduledFutureTask<V>(this, delayedTaskQueue,
				callable,
				ScheduledFutureTask.deadlineNanos(unit.toNanos(delay))));
	}

	@Override
	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
			long initialDelay, long period, TimeUnit unit) {
		if (command == null) {
			throw new NullPointerException("command");
		}
		if (unit == null) {
			throw new NullPointerException("unit");
		}
		if (initialDelay < 0) {
			throw new IllegalArgumentException(String.format(
					"initialDelay: %d (expected: >= 0)", initialDelay));
		}
		if (period <= 0) {
			throw new IllegalArgumentException(String.format(
					"period: %d (expected: > 0)", period));
		}

		return schedule(new ScheduledFutureTask<Void>(this, delayedTaskQueue,
				Executors.<Void> callable(command, null),
				ScheduledFutureTask.deadlineNanos(unit.toNanos(initialDelay)),
				unit.toNanos(period)));
	}

	@Override
	public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
			long initialDelay, long delay, TimeUnit unit) {
		if (command == null) {
			throw new NullPointerException("command");
		}
		if (unit == null) {
			throw new NullPointerException("unit");
		}
		if (initialDelay < 0) {
			throw new IllegalArgumentException(String.format(
					"initialDelay: %d (expected: >= 0)", initialDelay));
		}
		if (delay <= 0) {
			throw new IllegalArgumentException(String.format(
					"delay: %d (expected: > 0)", delay));
		}

		return schedule(new ScheduledFutureTask<Void>(this, delayedTaskQueue,
				Executors.<Void> callable(command, null),
				ScheduledFutureTask.deadlineNanos(unit.toNanos(initialDelay)),
				-unit.toNanos(delay)));
	}

	private <V> ScheduledFuture<V> schedule(final ScheduledFutureTask<V> task) {
		if (task == null) {
			throw new NullPointerException("task");
		}

		if (inEventLoop()) {
			delayedTaskQueue.add(task);
		} else {
			execute(new Runnable() {
				@Override
				public void run() {
					delayedTaskQueue.add(task);
				}
			});
		}

		return task;
	}

	private void startThread() {
		synchronized (stateLock) {
			if (state == ST_NOT_STARTED) {
				state = ST_STARTED;
				
				//间隔1s,清扫被取消的任务
				
				Callable<Void> callable = Executors.<Void> callable(new PurgeTask(), null);
				long deadlineNanos = ScheduledFutureTask.deadlineNanos(SCHEDULE_PURGE_INTERVAL);
				ScheduledFutureTask<Void> purgeFuture = new ScheduledFutureTask<Void>(this,
						delayedTaskQueue, callable, deadlineNanos,-SCHEDULE_PURGE_INTERVAL);
				
				
				delayedTaskQueue.add(purgeFuture);
				thread.start();
			}
		}
	}

	/**
	 * 
	 * 清扫任务
	 * @author Evan cppmain@gmail.com
	 *
	 */
	private final class PurgeTask implements Runnable {
		@Override
		public void run() {
			Iterator<ScheduledFutureTask<?>> i = delayedTaskQueue.iterator();
			while (i.hasNext()) {
				ScheduledFutureTask<?> task = i.next();
				if (task.isCancelled()) {
					i.remove();
				}
			}
		}
	}

}
