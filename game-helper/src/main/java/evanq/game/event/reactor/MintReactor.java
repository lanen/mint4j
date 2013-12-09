package evanq.game.event.reactor;

import evanq.game.event.dispatch.MintDispatcher;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class MintReactor {

	private static class Singleton {
		public static MintReactor INSTANCE = new ReactorImpl();
	}

	public static MintReactor getInstance() {
		return Singleton.INSTANCE;
	}

	private MintReactor() {
	}
	
	
	
	//生产线事件派发器
	private MintDispatcher dispatcher;
	
	
	
	public abstract void waitForEvent();
	public abstract void handlerEvent();
	public abstract void dispatch();
	public abstract void waitForEventHandleDone();
	
	static class ReactorImpl extends MintReactor {

		@Override
		public void waitForEvent() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void handlerEvent() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void waitForEventHandleDone() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		MintReactor reactor = MintReactor.getInstance();
		
		reactor.waitForEventHandleDone();
		
		
		
	}

}
