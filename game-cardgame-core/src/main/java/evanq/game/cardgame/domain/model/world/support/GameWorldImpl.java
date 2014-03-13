package evanq.game.cardgame.domain.model.world.support;

import evanq.game.net.DefaultPacketAllocator;
import evanq.game.net.INetService;
import evanq.game.net.sapi.NetServiceFactory;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class GameWorldImpl extends AbstractGameWorld  {
	
	public GameWorldImpl() {	
		super();
	}

	@Override
	public void start() {
		
		//
		initialze();
		WorldUtils.services().atfterStart();
		
		
		//调试网络通讯
		SocketServer(50000);
		block();

	}

	@Override
	public void stop() {
		
	}

	@Override
	public void process() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void RegisterPacket(){
		
		DefaultPacketAllocator.getInstance();
		
//		R(PacketConst.C_CONNECT_REQUEST, CRequestConnection.class);
//		R(PacketConst.S_CONNECT_REQUEST_OK, SRequestConnection_OK.class);
//		R(PacketConst.C_HEART_BEAT, CHeartBeat.class);
//		
	}
	
	public static void SocketServer(int port){
		RegisterPacket();
		
		INetService netService = NetServiceFactory.getNetService(port);
		netService.open();		
		
		
//		INetService netService2 = NetServiceFactory.getNetService(9002);
//		netService2.open();
		
			

	}

	private static Object lock = new Object();
	
	public static void block(){

		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					
					synchronized (lock) {
						try {
							lock.wait(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		t.start();
	}

}
