package evanq.game.net;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class ServerHelper {

	
	public static AgentNetService createAgent(NetServiceType type, int port){
		
		if(NetServiceType.AGENT_SERVER == type){
			
			AgentPacketAllocator.getInstance().doRegister();
			
			AgentNetConnectionManager instance = new AgentNetConnectionManager(NetServiceType.AGENT_SERVER);
			AgentNetService server = new AgentNetService(type, port, instance, AgentPacketAllocator.getInstance());
			
			return server;
		}
		
		if(NetServiceType.AGENT_CLIENT == type){
			
			AgentPacketAllocator.getInstance().doRegister();
			
			AgentNetConnectionManager instance = new AgentNetConnectionManager(NetServiceType.AGENT_CLIENT);	
			AgentNetService server = new AgentNetService(type, port, instance, AgentPacketAllocator.getInstance());
			return server;
		}
		return null;
	}
	public static INetService create(NetServiceType type, int port){
		
		if(type == NetServiceType.CLIENT){
			throw new IllegalArgumentException("不支持创建客户端连接");
		}
		
		if( ! validatePort(port) ){
			String msg= port + " 正在使用";
			System.err.println( msg );
			throw new IllegalArgumentException( msg ); 
		}
		
		switch(type){
		case AGENT_CLIENT:
		case AGENT_SERVER:
			return createAgent(type, port);
		case SERVER:
			break;
		default:
			break;
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
