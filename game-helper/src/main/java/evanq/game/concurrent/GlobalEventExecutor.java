package evanq.game.concurrent;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;

/**
 * 
 * 此类被设计为单例，提供一个公用的{@link EventExecutor}。
 * <br/>  
 * 线程中断时候，是无法执行当前线程的清扫任务，故而将中断时候的清扫任务提交给 {@link GlobalEventExecutor}
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class GlobalEventExecutor extends AbstractEventExecutor {
	private static final Trace logger = LogSystem.getDefaultTrace(GlobalEventExecutor.class);


    private static final int ST_NOT_STARTED = 1;
    private static final int ST_STARTED = 2;

    //清除任务的调度时间间隔
    private static final long SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1);

    //单例模式
    public static final GlobalEventExecutor INSTANCE = new GlobalEventExecutor();
    
    //任务队列
    final Queue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
    
    //延迟执行的任务队列
    final Queue<ScheduledFutureTask<?>> delayedTaskQueue = new PriorityQueue<ScheduledFutureTask<?>>();
    
    //清除任务的任务
    final ScheduledFutureTask<Void> purgeTask = new ScheduledFutureTask<Void>(
            this, delayedTaskQueue, Executors.<Void>callable(new PurgeTask(), null),
            ScheduledFutureTask.deadlineNanos(SCHEDULE_PURGE_INTERVAL), -SCHEDULE_PURGE_INTERVAL);
    
    //线程工厂
    private final ThreadFactory threadFactory = new DefaultThreadFactory(getClass());
    
    //任务在里被执行
    private final TaskRunner taskRunner = new TaskRunner();

    private final Object stateLock = new Object();

    //当前线程
    volatile Thread thread;
    
    //线程状态
    private volatile int state = ST_NOT_STARTED;

    private final Future<?> terminationFuture = new FailedFuture<Object>(this, new UnsupportedOperationException());

    private GlobalEventExecutor() {
    	//在初始化的时候，就添加一个清扫的队列的任务
    	
        delayedTaskQueue.add(purgeTask);
    }

    @Override
    public EventExecutorGroup parent() {
        return null;
    }

    /**
     * 
     * 从任务队列中取出任务，为空时阻塞
     * <br/>
     * Take the next {@link Runnable} from the task queue and so will block if no task is currently present.
     * 在线程被中断或被唤醒时，返回null
     * 
     * @return {@code null} if the executor thread has been interrupted or waken up.
     */
    Runnable takeTask() {
        BlockingQueue<Runnable> taskQueue = (BlockingQueue<Runnable>) this.taskQueue;
        for (;;) {
        	//
            ScheduledFutureTask<?> delayedTask = delayedTaskQueue.peek();
            if (delayedTask == null) {
                Runnable task = null;
                try {
                    task = taskQueue.take();
                } catch (InterruptedException e) {
                    // Ignore
                }
                return task;
            } else {
                long delayNanos = delayedTask.delayNanos();
                Runnable task;
                if (delayNanos > 0) {
                    try {
                        task = taskQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
                    } catch (InterruptedException e) {
                        return null;
                    }
                } else {
                    task = taskQueue.poll();
                }

                if (task == null) {
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
     * Return the number of tasks that are pending for processing.
     *
     * <strong>Be aware that this operation may be expensive as it depends on the internal implementation of the
     * SingleThreadEventExecutor. So use it was care!</strong>
     */
    public int pendingTasks() {
        return taskQueue.size();
    }

    /**
     * Add a task to the task queue, or throws a {@link RejectedExecutionException} if this instance was shutdown
     * before.
     */
    private void addTask(Runnable task) {
        if (task == null) {
            throw new NullPointerException("task");
        }
        taskQueue.add(task);
    }

    @Override
    public boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    @Override
    public Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit) {
        return terminationFuture();
    }

    @Override
    public Future<?> terminationFuture() {
        return terminationFuture;
    }

    @Override
    public boolean isShuttingDown() {
        return false;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) {
        return false;
    }

    @Override
    public void execute(Runnable task) {
        if (task == null) {
            throw new NullPointerException("task");
        }

        addTask(task);
        if ( ! inEventLoop()) {
            startThread();
        }
    }

    // ScheduledExecutorService implementation

    @Override
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        if (command == null) {
            throw new NullPointerException("command");
        }
        if (unit == null) {
            throw new NullPointerException("unit");
        }
        if (delay < 0) {
            throw new IllegalArgumentException(
                    String.format("delay: %d (expected: >= 0)", delay));
        }
        return schedule(new ScheduledFutureTask<Void>(
                this, delayedTaskQueue, command, null, ScheduledFutureTask.deadlineNanos(unit.toNanos(delay))));
    }

    @Override
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        if (callable == null) {
            throw new NullPointerException("callable");
        }
        if (unit == null) {
            throw new NullPointerException("unit");
        }
        if (delay < 0) {
            throw new IllegalArgumentException(
                    String.format("delay: %d (expected: >= 0)", delay));
        }
        return schedule(new ScheduledFutureTask<V>(
                this, delayedTaskQueue, callable, ScheduledFutureTask.deadlineNanos(unit.toNanos(delay))));
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        if (command == null) {
            throw new NullPointerException("command");
        }
        if (unit == null) {
            throw new NullPointerException("unit");
        }
        if (initialDelay < 0) {
            throw new IllegalArgumentException(
                    String.format("initialDelay: %d (expected: >= 0)", initialDelay));
        }
        if (period <= 0) {
            throw new IllegalArgumentException(
                    String.format("period: %d (expected: > 0)", period));
        }

        return schedule(new ScheduledFutureTask<Void>(
                this, delayedTaskQueue, Executors.<Void>callable(command, null),
                ScheduledFutureTask.deadlineNanos(unit.toNanos(initialDelay)), unit.toNanos(period)));
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        if (command == null) {
            throw new NullPointerException("command");
        }
        if (unit == null) {
            throw new NullPointerException("unit");
        }
        if (initialDelay < 0) {
            throw new IllegalArgumentException(
                    String.format("initialDelay: %d (expected: >= 0)", initialDelay));
        }
        if (delay <= 0) {
            throw new IllegalArgumentException(
                    String.format("delay: %d (expected: > 0)", delay));
        }

        return schedule(new ScheduledFutureTask<Void>(
                this, delayedTaskQueue, Executors.<Void>callable(command, null),
                ScheduledFutureTask.deadlineNanos(unit.toNanos(initialDelay)), -unit.toNanos(delay)));
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

                thread = threadFactory.newThread(taskRunner);

                thread.start();
            }
        }
    }

    /**
     * 
     * 遍历任务队列，执行任务内容
     * 
     * @author Evan cppmain@gmail.com
     *
     */
    final class TaskRunner implements Runnable {
        @Override
        public void run() {
            for (;;) {
                Runnable task = takeTask();
                if (task != null) {
                    try {
                        task.run();
                    } catch (Throwable t) {
                        logger.warn("Unexpected exception from the global event executor: ", t);
                    }
                    
                    if (task != purgeTask) {
                        continue;
                    }
                }

                if (taskQueue.isEmpty() && delayedTaskQueue.size() == 1) {
                    synchronized (stateLock) {
                    	//在任务队列为空，等待队列只剩下清理任务是，关闭线程
                        // Terminate if there is no task in the queue (except the purge task).
                        if (taskQueue.isEmpty() && delayedTaskQueue.size() == 1) {
                            state = ST_NOT_STARTED;
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 
     * 将被取消的任务从等待队列中移除
     * 
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

    
	@Override
	public void shutdown() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Runnable> shutdownNow() {
		throw new UnsupportedOperationException();
	}
}
