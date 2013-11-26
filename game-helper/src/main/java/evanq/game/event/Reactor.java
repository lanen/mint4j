package evanq.game.event;

import evanq.game.helper.Registry;

/**
 * Reactor Pattern
 * 
 * 反应堆
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class Reactor {
	
	//处理器注册表
	private Registry<Integer,EventHandler> handlerRegistry = new Registry<Integer,EventHandler>();
	
	public void registerHandle(EventHandler handle){
		handlerRegistry.put(handle.getEventFlag(), handle);
	}
	
	public abstract void waitForEvent();
	public abstract void handlerEvent();
	public abstract void dispatch();
	public abstract void waitForEventHandleDone();
	
	static class ReactorImpl {
		
	}
}
