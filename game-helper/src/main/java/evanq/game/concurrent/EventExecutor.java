package evanq.game.concurrent;


/**
 * 
 * 
 * 提供了检测事件循环是否在同一个线程中的方法
 * 
 */
public interface EventExecutor extends EventExecutorGroup {

    /**
     * 返回自身引用
     */
    @Override
    EventExecutor next();

    /**
     *
     * Return the {@link EventExecutorGroup} which is the parent of this {@link EventExecutor},
     */
    EventExecutorGroup parent();

    /**
     * Calls {@link #inEventLoop(Thread)} with {@link Thread#currentThread()} as argument
     */
    boolean inEventLoop();

    /**
     * 检测指定线程是否进入事件循环
     * 
     */
    boolean inEventLoop(Thread thread);

    /**
     * 
     * 生成一个可变的结果
     * 
     * Return a new {@link Promise}.
     */
    <V> Promise<V> newPromise();

    
    /**
     * Create a new {@link Future} which is marked as successes already. So {@link Future#isSuccess()}
     * will return {@code true}. All {@link FutureListener} added to it will be notified directly. Also
     * every call of blocking methods will just return without blocking.
     */
    <V> Future<V> newSucceededFuture(V result);

    /**
     * Create a new {@link Future} which is marked as fakued already. So {@link Future#isSuccess()}
     * will return {@code false}. All {@link FutureListener} added to it will be notified directly. Also
     * every call of blocking methods will just return without blocking.
     */
    <V> Future<V> newFailedFuture(Throwable cause);


}
