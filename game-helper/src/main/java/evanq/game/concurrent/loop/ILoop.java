package evanq.game.concurrent.loop;

import evanq.game.concurrent.EventExecutor;



/**
 * 帧 Frame
 * 
 * 一个“事件循环”，负责执行执行注册进来的{@link ITask}。 
 * <br/>
 * 具体是一个{@link ILoop} 对 一个或多个{@link ITask},由具体实现决定
 * 
 * <li>
 * {@link ITask} 注册进入 {@link ILoop} 产生一个 {@link ITaskFuture}
 * </li>
 * <li>
 * {@link ITask} 不允许被多次注册，且只能被一个{@link ILoop}接受
 * </li>
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface ILoop extends EventExecutor,ILoopGroup {

	@Override
	ILoopGroup parent();
}
