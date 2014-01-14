package evanq.game.concurrent.loop;


import java.util.concurrent.ThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.concurrent.DefaultThreadFactory;
import evanq.game.concurrent.MultithreadEventExecutorGroup;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;
import evanq.game.utils.SystemPropertyUtil;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class MultithreadLoopGroup extends
		MultithreadEventExecutorGroup implements ILoopGroup {

	private static final Trace logger = LogSystem.getDefaultTrace(MultithreadLoopGroup.class);

    private static final int DEFAULT_EVENT_LOOP_THREADS;
    
    static {
    	//线程池默认线程数
        DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt(
                "pool.thread.defaultSize", Runtime.getRuntime().availableProcessors() * 2));

        if (logger.isDebugEnabled()) {
            logger.debug("-Dpool.thread.defaultSize: {}", DEFAULT_EVENT_LOOP_THREADS);
        }
    }

    /**
     * @see {@link MultithreadEventExecutorGroup#MultithreadEventExecutorGroup(int, ThreadFactory, Object...)}
     */
    protected MultithreadLoopGroup(int nThreads, ThreadFactory threadFactory, Object... args) {
        super(nThreads == 0? DEFAULT_EVENT_LOOP_THREADS : nThreads, threadFactory, args);
    }

    @Override
    protected ThreadFactory newDefaultThreadFactory() {
    	
    	return new DefaultThreadFactory(getClass(), Thread.MAX_PRIORITY);
    }

    @Override
    public ILoop next() {
        return (ILoop) super.next();
    }

	@Override
	public ITaskFuture register(ITask task) {
		return next().register(task);
	}

}
