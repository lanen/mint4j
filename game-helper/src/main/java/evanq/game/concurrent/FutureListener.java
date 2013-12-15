package evanq.game.concurrent;

/**
 * A subtype of {@link GenericFutureListener} that hides type parameter for convenience.
 * <pre>
 * Future f = new DefaultPromise(..);
 * f.addListener(new FutureListener() {
 *     public void operationComplete(Future f) { .. }
 * });
 * </pre>
 */
public interface FutureListener<V>  extends GenericFutureListener<Future<V>> {

}
