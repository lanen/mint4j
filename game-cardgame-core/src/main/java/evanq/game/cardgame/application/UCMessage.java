package evanq.game.cardgame.application;

/**
 * 
 * 消息用例
 * @author Evan cppmain@gmail.com
 *
 */
public interface UCMessage {

	/**
	 * 消息类型，消息内容，给谁
	 * @param msgCode
	 * @param msg
	 */
	public void message(int msgCode,String msg);
	
}
