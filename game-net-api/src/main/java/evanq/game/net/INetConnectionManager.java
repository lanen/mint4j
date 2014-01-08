package evanq.game.net;

public interface INetConnectionManager {

	//map<INetConnectionGroup,INetConnectionHolder>
	
	//final UnAuthGroupHolder;
	//final UnAuthNetConnectionPurgeTask - 清扫任务
	//final HeartBeatTask
	//final ServerClosingTask
	//final 
	public void accpet(INetConnection connection);

	public void close(INetConnection connection);
	
	
}
