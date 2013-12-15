package evanq.game.concurrent.loop;

import evanq.game.concurrent.EventExecutorGroup;

/**
 * 
 * 继承自{@link EventExecutorGroup}, 允许注册{@link ITask} 到事件执行线程中
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface ILoopGroup extends EventExecutorGroup {
	/**
     * Return the next {@link ILoop} to use
     */
    @Override
    ILoop next();


    /**
     * 
     * 注册 {@link ITask} 到 {@link ILoop} 事件循环中。
     * 在循环的执行过程中，遵循{@link ITaskFutrue} 的监听器规则
     * 
     * @param task
     * @return
     */
    ITaskFuture register(ITask task);
    
    /**
     * 注册 {@link ITask} 到 {@link ILoop} 事件循环中。
     *  
     * @param task
     * @param nanaTime 开始执行的时间
     * @param period 执行的间隔时间
     * @return
     */
    ITaskFuture register(ITask task, long nanaTime,long period);
 
}
