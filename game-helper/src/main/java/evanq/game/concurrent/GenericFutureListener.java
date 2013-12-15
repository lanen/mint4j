package evanq.game.concurrent;



import java.util.EventListener;


/**
 * {@link Future} 的监听器，{@link Future} 产生结果，会通知此接口
 * 
 * {@link Future#addListener(GenericFutureListener)} 方法注册接口
 * 
 * @author Evan cppmain@gmail.com
 *
 * @param <F>
 */
public interface GenericFutureListener <F extends Future<?>> extends EventListener {
   
	/**
     * Invoked when the operation associated with the {@link Future} has been completed.
     *
     * @param future  the source {@link Future} which called this callback
     */
    void operationComplete(F future) throws Exception;

}
