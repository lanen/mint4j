package evanq.game.net;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class ServerHelper {

	public static INetService create(NetServiceType type, int port){
		if(type == NetServiceType.CLIENT){
			throw new IllegalArgumentException("不支持创建客户端连接");
		}
		
		if( ! validatePort(port) ){
			String msg= port + " 正在使用";
			System.err.println( msg );
			throw new IllegalArgumentException( msg ); 
		}
		
		if(NetServiceType.AGENT_SERVER == type){
			
			AgentPacketAllocator.getInstance().doRegister();
			
			AgentNetConnectionManager instance = null;	
			AgentServer server = new AgentServer(type, port, instance, AgentPacketAllocator.getInstance());
			return server;
		}
		
		if(NetServiceType.AGENT_CLIENT == type){
			return null;
		}
		
		if(NetServiceType.SERVER == type){
			return null;
		}
		
		return null;
	}
	
	public static  boolean validatePort(int port){
		return true;
	}
	
	public static INetService establishNetServiceToAgentService(String agentHost,int agentPort){
		return null;
	}
	
}
