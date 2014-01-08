package evanq.game.net;

public class Agent {

	/**
	 * 来自客户端的，会被在这里
	 */
	private AgentNetService clientAgent;
	
	/**
	 * 来自服务端的，会在这里
	 */
	private AgentNetService serverAgent;
	
	//Agent 保持准发规则
	
	public Agent(){		
		
		clientAgent = ServerHelper.createAgent(NetServiceType.AGENT_CLIENT, 50000);		
		serverAgent = ServerHelper.createAgent(NetServiceType.AGENT_SERVER, 7000);
	
		//c come packet
		//route c to serverAgent connection
		//write packet to connection
		
		//s come packet
		//route s to clientAgent connection
		//write packet to connection
	}
	
	public void start(){
		clientAgent.open();
		serverAgent.open();
	}
	
	
	public void route(IPacket packet){
		
	}
	
	
	interface RouteRule {
		//数据包拥有packet id
		//packet id 会分布在server type 下
		//route 会轮训分发
	}
	
	public static void main(String[] args) {
	
		Agent agent = new Agent();
		//模拟连接进来
		
		//模拟建立连接
		
		//模拟分发
		
		//模拟预订（clientAgent 接受来自 serverAgent 的数据包）
	}
}
