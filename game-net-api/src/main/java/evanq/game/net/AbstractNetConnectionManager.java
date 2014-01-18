package evanq.game.net;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import evanq.game.concurrent.DefaultThreadFactory;
import evanq.game.concurrent.ScheduledFuture;
import evanq.game.concurrent.loop.AbstractTask;
import evanq.game.concurrent.loop.DefaultLoopGroup;
import evanq.game.concurrent.loop.ICommand;
import evanq.game.helper.New;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;
import evanq.game.trace.TraceConstant;

/**
 * 网络连接管理器
 * 
 * @see INetConnectionHolder
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractNetConnectionManager implements INetConnectionManager {
	
	private static Trace logger = LogSystem.getDefaultTrace(TraceConstant.CONNECTION);
	
	protected Map<INetConnection,INetConnectionHolder> connections = New.newConcurrentHashMap();
	
	private LookAtNetService lookAtNetService;
	
	/**
	 * 用于管理的类型
	 */
	protected NetServiceType serviceType;
	
	private SingleThreadHolder holder;

	/**
	 * 
	 * 心跳管理
	 */
	protected INetHeartGroup heartGroup;
	
	/**
	 * 
	 * @param serviceType
	 */
	protected AbstractNetConnectionManager(NetServiceType serviceType) {
		
		this.serviceType = serviceType;
		
		heartGroup = new HeartBeatGroup();

		holder = new SingleThreadHolder();		
		holder.registerHeartBeatTask(new NetHeartBeatTask(heartGroup));
		holder.registerDelayClosingTask(new DelayClosingTask(this));
		holder.registerUnAuthPurgeTask(new PurgeTask(this));
		
		lookAtNetService = new LookAtNetService(this);
	}
	
	
	@Override
	public void addConnection(INetConnection connection) {
		//讲连接增加到容易
		
	}

	@Override
	public void removeConnection(INetConnection connection) {		
		
	}
	
	public void registerHeart(INetHeart heart){
		heartGroup.add(heart);
	}
	
	public void deRegisterHeart(INetHeart heart){
		heartGroup.remove(heart);
	}
	
	//TODO 一旦连接建立，遍给他建立一个状态机。
	/**
	 * 不同类型的连接，可能需要不同的状态机来管理，这里可以拓展
	 * @param connection
	 * @return
	 */
	protected abstract INetConnectionFSM createNetConnectionFSM(INetConnection connection);
	
	public SingleThreadHolder singleThread(){
		return holder;
	}
	
	public INetServiceListener getNetServiceListener(){
		return lookAtNetService;
	}
	
	/**
	 * 
	 * 建立一个线程任务来处理
	 * 
	 * @author Evan cppmain@gmail.com
	 *
	 */
	static class SingleThreadHolder extends AbstractTask {
		
		private DefaultLoopGroup group ;
		
		/**
		 * 心跳包的定时任务
		 */
		ScheduledFuture<?> heartBeatScheduledFuture;
		
		/**
		 * 延迟关闭任务
		 */
		ScheduledFuture<?> delayClosingScheduledFuture;

		/**
		 * 验证失败，或悬空连接清扫任务
		 */
		ScheduledFuture<?> unAuthedPurgeScheduledFuture;
		
		public SingleThreadHolder() {
			super(null);
			
			//管理连接的线程
			DefaultThreadFactory threadFactory = new DefaultThreadFactory("connection-manager", Thread.MAX_PRIORITY);
			group = new DefaultLoopGroup(1,threadFactory);
			group.register(this);
			
		}
		
		@Override
		protected void doRegister() {
			
		}

		@Override
		protected void doAccept(ICommand command) {
			try{
				command.execute();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		void registerHeartBeatTask(Runnable runnable){
			heartBeatScheduledFuture = group.scheduleWithFixedDelay(runnable, 0, INetHeartGroup.HEART_BEAT_DELAY, TimeUnit.MILLISECONDS);
		}
		
		//TODO 暂定关闭任务2s 执行一次
		void registerDelayClosingTask(Runnable runnable){
			delayClosingScheduledFuture = group.scheduleWithFixedDelay(runnable, 0, 2000, TimeUnit.MILLISECONDS);
		}
		//TODO 暂定清扫任务3s 执行一次
		void registerUnAuthPurgeTask(Runnable runnable){
			unAuthedPurgeScheduledFuture = group.scheduleWithFixedDelay(runnable, 0, 3000, TimeUnit.MILLISECONDS);
		}
		
	}

	
	static class HeartBeatGroup implements INetHeartGroup {

		private Collection<INetHeart> hearts = New.linkedList();
		
		@Override
		public void add(INetHeart heart) {
			hearts.add(heart);
		}

		@Override
		public void remove(INetHeart heart) {
			hearts.remove(heart);
		}

		@Override
		public void beat() {
			for (INetHeart heart : hearts) {
				heart.beat();
			}
		}
		
	}
	
	static class DelayClosingTask implements Runnable{
		
		AbstractNetConnectionManager manager ;
		
		DelayClosingTask(AbstractNetConnectionManager manager) {
			this.manager = manager;
		}
		
		@Override
		public void run() {
			
		}
		
	}
	static class PurgeTask implements Runnable{
		
		AbstractNetConnectionManager manager ;

		PurgeTask(AbstractNetConnectionManager manager) {
			this.manager = manager;
		}
		
		@Override
		public void run() {
			
		}
		
	}
	
	/**
	 * 
	 * 
	 * @author Evan cppmain@gmail.com
	 *
	 */
	static class LookAtNetService implements INetServiceListener {
		
		AbstractNetConnectionManager manager ;
		
		public LookAtNetService(AbstractNetConnectionManager manager) {
			this.manager = manager;
		}
		@Override
		public void willStartNetService(INetService netService) {
			manager.logger.info("AbstractNetConnectionManager.LookAtNetService.willStartNetService()");
		}

		@Override
		public void didStartNetService(INetService netService) {
			manager.logger.info("AbstractNetConnectionManager.LookAtNetService.didStartNetService()");
			
		}

		@Override
		public void willCloseNetService(INetService netService) {
			manager.logger.info("AbstractNetConnectionManager.LookAtNetService.willCloseNetService()");
			
		}

		@Override
		public void didCloseNetService(INetService netService) {
			manager.logger.info("AbstractNetConnectionManager.LookAtNetService.didCloseNetService()");			
		}
		
	}
	
}
