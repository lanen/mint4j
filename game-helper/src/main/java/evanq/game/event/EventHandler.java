package evanq.game.event;

/**
 * 实现响应器
 * 
 * 
 * handoff 切换
 * 
 * callback : dispatch event handler
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class EventHandler {
	
	protected int forEventFlag;
	
	protected EventHandler(int forEvent){
		this.forEventFlag = forEvent;
	}
	
	public int getEventFlag(){
		return forEventFlag;
	}
	
}
