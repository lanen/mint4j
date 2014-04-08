package evanq.game.cardgame.domain.model.world.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.infrastructure.mint.protocol.Opcode;
import evanq.game.infrastructure.mint.world.GameWorldPart;
import evanq.game.net.INetService;
import evanq.game.net.sapi.NetServiceFactory;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class NetworkGameWorldPart implements GameWorldPart {

	private Logger logger = LoggerFactory.getLogger(NetworkGameWorldPart.class);
	
	@Override
	public void buildPart() {
		
		logger.info("build network part");
		
		
		
		
		//调试网络通讯		
		SocketServer(50000);

	}
	
	public static void RegisterPacket(){
	
		//读取协议部分
		Opcode opcode = new Opcode();
		opcode.opcodeFromINIProtocolFile("protocol.ini");
		
		//TODO 加载Socket服务器端口配置
		
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
