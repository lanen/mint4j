package evanq.game.concurrent.loop;

import java.util.concurrent.ThreadFactory;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class DefaultLoopGroup extends MultithreadLoopGroup {

	public DefaultLoopGroup(int nThreads){
		super(nThreads,null);
	}
	
	protected DefaultLoopGroup(int nThreads, ThreadFactory threadFactory,
			Object[] args) {
		super(nThreads, threadFactory, args);
	}

	@Override
	protected ILoop newChild(ThreadFactory threadFactory,
			Object... args) throws Exception {
	
		return new DefaultLoop(this,threadFactory);
	}

}
