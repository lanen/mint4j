package evanq.game.net.agent;

import static evanq.game.net.DefaultPacketAllocator.R;
import evanq.game.net.DefaultPacketAllocator;
import evanq.game.net.INetService;
import evanq.game.net.NetConnectionType;
import evanq.game.net.PacketConst;
import evanq.game.net.packets.CHeartBeat;
import evanq.game.net.packets.CRequestConnection;
import evanq.game.net.packets.SRequestConnection_OK;
import evanq.game.net.sapi.NetServiceFactory;

public class AgentClientMain {

	
	public static final int CLIENT_AGENT_PORT = 10000;
	public static final int SERVER_AGENT_PORT = 7000;
	
	
	public static void RegisterPacket(){
		
		DefaultPacketAllocator.getInstance();
		
		R(PacketConst.C_CONNECT_REQUEST, CRequestConnection.class);
		R(PacketConst.S_CONNECT_REQUEST_OK, SRequestConnection_OK.class);
		R(PacketConst.C_HEART_BEAT, CHeartBeat.class);
		
	}

	
	public static void main(String[] args) {
		
		
		RegisterPacket();
		
		//用于接收客户端的连接
		INetService netService = NetServiceFactory.getNetService(8321);
		netService.open();
		
		
		//会自动连接
		INetService toScene = NetServiceFactory.getNetService(NetConnectionType.NODE_IN_AGENT_SCENE,"127.0.0.1",9001);
		toScene.open();
		
//		INetService toChat = NetServiceFactory.getNetService(NetConnectionType.NODE_IN_AGENT_CHAT,"127.0.0.1",9001);
//		toChat.open();
//		
//		INetService toWorld = NetServiceFactory.getNetService(NetConnectionType.NODE_IN_AGENT_LOGINSERVER,"127.0.0.1",9001);
//		toWorld.open();

		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public synchronized void run() {
				while(true){
					
					try {
						wait(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}
}
