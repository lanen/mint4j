package evanq.game.net;

import java.util.Map;

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
	 * @param serviceType
	 */
	protected AbstractNetConnectionManager(NetServiceType serviceType) {
		
		//提供一个日志跟踪器
		StringBuffer s = new StringBuffer()	;
		s.append(TraceConstant.CONNECTION).append("[").append(serviceType).append("]");
		logger = LogSystem.getDefaultTrace(s.toString());
		
		this.serviceType = serviceType;
		
		holder = new SingleThreadHolder();
		
		lookAtNetService = new LookAtNetService(this);
	}
	
	@Override
	public void accpet(INetConnection connection) {
		
		//TODO 一旦连接建立，遍给他建立一个状态机。
		//不同类型的连接，可能需要不同的状态机来管理，这里可以拓展
		AbstractNetConnectionFSM fsm = new AbstractNetConnectionFSM(this, connection);
		fsm.fireEvent(NetConnectionEvent.CREATE_OK);
	}

	@Override
	public void close(INetConnection connection) {		
		connection.fsm().fireEvent(NetConnectionEvent.CLOSE);		
	}
	

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
		
		private DefaultLoopGroup group = new DefaultLoopGroup(1);
		
		public SingleThreadHolder() {
			super(null);	
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
