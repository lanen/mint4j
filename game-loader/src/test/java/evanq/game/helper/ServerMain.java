package evanq.game.helper;

import evanq.game.net.DefaultPacketAllocator;
import evanq.game.net.INetService;
import evanq.game.net.sapi.NetServiceFactory;
/**
 * 
 * 模拟一个业务服务节点
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ServerMain {

	public static void RegisterPacket(){
		
		DefaultPacketAllocator.getInstance();
		
//		R(PacketConst.C_CONNECT_REQUEST, CRequestConnection.class);
//		R(PacketConst.S_CONNECT_REQUEST_OK, SRequestConnection_OK.class);
//		R(PacketConst.C_HEART_BEAT, CHeartBeat.class);
		
	}
	
	public static void main(String[] args) {
		
		RegisterPacket();
		
		INetService netService = NetServiceFactory.getNetService(9001);
		
		netService.open();
		
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
