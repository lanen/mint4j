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
	
	private Trace logger ;
	
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
		
		//提供一个日志跟踪器
		StringBuffer s = new StringBuffer()	;
		s.append(TraceConstant.CONNECTION).append("[").append(serviceType).append("]");
		logger = LogSystem.getDefaultTrace(s.toString());
		
		this.serviceType = serviceType;
		
		heartGroup = new HeartBeatGroup();

		holder = new SingleThreadHolder();		
		holder.registerHeartBeatTask(new NetHeartBeatTask(heartGroup));
		
		lookAtNetService = new LookAtNetService(this);
	}
	
	
	@Override
	public void accpet(INetConnection connection) {
		INetConnectionFSM fsm = createNetConnectionFSM(connection);
		fsm.fireEvent(NetConnectionEvent.CREATE_OK);
	}

	@Override
	public void close(INetConnection connection) {
		
		connection.fsm().fireEvent(NetConnectionEvent.CLOSE);
	}
	
	public void registerHeart(INetHeart heart){
		logger.info("register heart {}",heart);
		heartGroup.add(heart);
	}
	
	public void deRegisterHeart(INetHeart heart){
		logger.info("deRegister heart {}",heart);
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
		
		public void registerHeartBeatTask(Runnable runnable){
			heartBeatScheduledFuture = group.scheduleWithFixedDelay(runnable, 0, INetHeartGroup.HEART_BEAT_DELAY, TimeUnit.MILLISECONDS);
		}
		
	}

	
	static class HeartBeatGroup implements INetHeartGroup{

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
