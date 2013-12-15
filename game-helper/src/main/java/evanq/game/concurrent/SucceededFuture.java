package evanq.game.concurrent;


/**
 * 一个成功的执行结果
 * use {@link EventExecutor#newSucceededFuture(Object)} 而不是直接构造这个类
 * 
 */
public final class SucceededFuture<V> extends CompleteFuture<V> {
    private final V result;

    /**
     * Creates a new instance.
     *
     * @param executor the {@link EventExecutor} associated with this future
     */
    public SucceededFuture(EventExecutor executor, V result) {
        super(executor);
        this.result = result;
    }

    @Override
    public Throwable cause() {
        return null;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public V getNow() {
        return result;
    }
}
