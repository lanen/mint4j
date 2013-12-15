package evanq.game.concurrent;

import evanq.game.utils.ExceptionUtils;


/**
 * The {@link CompleteFuture} which is failed already.  It is
 * recommended to use {@link EventExecutor#newFailedFuture(Throwable)}
 * instead of calling the constructor of this future.
 */
public final class FailedFuture<V> extends CompleteFuture<V> {

    private final Throwable cause;

    /**
     * Creates a new instance.
     *
     * @param executor the {@link EventExecutor} associated with this future
     * @param cause   the cause of failure
     */
    public FailedFuture(EventExecutor executor, Throwable cause) {
        super(executor);
        if (cause == null) {
            throw new NullPointerException("cause");
        }
        this.cause = cause;
    }

    @Override
    public Throwable cause() {
        return cause;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public Future<V> sync() {
        ExceptionUtils.throwException(cause);
        return this;
    }

    @Override
    public Future<V> syncUninterruptibly() {
    	ExceptionUtils.throwException(cause);
        return this;
    }

    @Override
    public V getNow() {
        return null;
    }
}
