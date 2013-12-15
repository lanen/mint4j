package evanq.game.concurrent;


import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * {@link EventExecutor} 组
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface EventExecutorGroup extends ScheduledExecutorService , Iterable<EventExecutor>{
  
	/**
     * Returns {@code true} if and only if this executor was started to be
     * {@linkplain #shutdownGracefully() shut down gracefuclly} or was {@linkplain #isShutdown() shut down}.
     */
    boolean isShuttingDown();

    /**
     * Shortcut method for {@link #shutdownGracefully(long, long, TimeUnit)} with sensible default values.
     *
     * @return the {@link #terminationFuture()}
     */
    Future<?> shutdownGracefully();

    /**
     * 将当前执行器标记成“即将关闭”。
     * <br/>
     * 该方法被调用，{@link #isShuttingDown()} 返回 {@code true}。
     * 参数 quietPeriod 设置
     * 
     * @param quietPeriod the quiet period as described in the documentation
     * @param timeout     the maximum amount of time to wait until the executor is {@linkplain #shutdown()}
     *                    regardless if a task was submitted during the quiet period
     * @param unit        the unit of {@code quietPeriod} and {@code timeout}
     *
     * @return the {@link #terminationFuture()}
     */
    Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit);

    /**
     * 
     * 返回一个代表任务中断结果的{@link Future}
     */
    Future<?> terminationFuture();

    /**
     * {@link EventExecutorGroup} 中一个{@link EventExecutor}
     * 如：返回线程组的一个线程
     * 
     */
    EventExecutor next();

    /**
     * Returns a read-only {@link Iterator} over all {@link EventExecutor}, which are handled by this
     * {@link EventExecutorGroup} at the time of invoke this method.
     */
    @Override
    Iterator<EventExecutor> iterator();

    @Override
    Future<?> submit(Runnable task);

    @Override
    <T> Future<T> submit(Runnable task, T result);

    @Override
    <T> Future<T> submit(Callable<T> task);

    @Override
    ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);

    @Override
    <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit);

    @Override
    ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);

    @Override
    ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);

}
