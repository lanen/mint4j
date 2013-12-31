package evanq.game.net;

public interface INetManager {

	//map<INetConnectionGroup,INetConnectionHolder>
	
	//final UnAuthGroupHolder;
	//final UnAuthNetConnectionPurgeTask - 清扫任务
	//final HeartBeatTask
	//final ServerClosingTask
	//final 
	public void accpet(INetConnectionGroup group);
	
	
	public void close(INetConnectionHolder holder);
	
	/**
	 * 心跳
	 */
	public void heat();
	
}
