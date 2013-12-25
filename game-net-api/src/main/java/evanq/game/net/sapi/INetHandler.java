package evanq.game.net.sapi;

import evanq.game.net.INetConnection;

/**
 * 
 * 职责：<br/>
 * <ul>
 * <li>接受和关闭连接</li>
 * <li>收、发数据</li>
 * </ul>
 * 
 * 
 * @author Evan
 *
 */
public interface INetHandler {

	
	/**
	 * 
	 * @param con
	 */
	public void onCreated(INetConnection con);
	
	/**
	 * 
	 * @param con
	 */
	public void onClose(INetConnection con);
	
	
	/**
	 * 
	 * @param data
	 * @param codec
	 */
	public void onSent(byte[] data);
	
	/**
	 * 
	 * @param data
	 */
	public void onRecv(byte[] data);
}
