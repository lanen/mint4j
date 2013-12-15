package evanq.game.concurrent;

public interface GenericProgressiveFutureListener<F extends ProgressiveFuture<?>>
		extends GenericFutureListener<F> {
	
    /**
     * Invoked when the operation has progressed.
     *
     * @param progress the progress of the operation so far (cumulative)
     * @param total the number that signifies the end of the operation when {@code progress} reaches at it.
     *              {@code -1} if the end of operation is unknown.
     */
    void operationProgressed(F future, long progress, long total) throws Exception;

}
