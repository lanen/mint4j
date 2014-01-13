package evanq.game.net;

import evanq.game.net.manager.AgentClientNetConnectionManager;
import evanq.game.net.manager.AgentServerNetConnectionManager;
import evanq.game.net.manager.ClientNetConnectionManager;

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
			
			AgentServerNetConnectionManager instance = new AgentServerNetConnectionManager();

			AgentNetService server = new AgentNetService(type, port, instance, AgentPacketAllocator.getInstance());
			
			return server;
		}
		
		if(NetServiceType.AGENT_CLIENT == type){
			
			AgentPacketAllocator.getInstance().doRegister();
			AgentClientNetConnectionManager instance = new AgentClientNetConnectionManager();

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
	
	/**
	 * 
	 * 
	 * @param agentHost
	 * 
	 * @param agentPort
	 * @param type
	 * @return
	 */
	public static INetService establishNetServiceToAgentService(String agentHost,int agentPort,NetConnectionType type){
		ClientNetConnectionManager clientNetConnectionManager = new ClientNetConnectionManager();
		
		NetServiceAdaptor adaptor = new NetServiceAdaptor(NetServiceType.CLIENT,agentHost,agentPort,clientNetConnectionManager,PacketAllocator.getInstance());
		
		return adaptor;
	}
	
	public static INetService establishNetServiceToAgentService(String agentHost,int agentPort){
		
		INetService establishNetServiceToAgentService = establishNetServiceToAgentService(agentHost,agentPort, NetConnectionType.DUMMY);
		
		return establishNetServiceToAgentService;
	}
	
}
