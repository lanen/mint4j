package evanq.game.net.agent;

import evanq.game.net.INetService;
import evanq.game.net.ServerHelper;

public class ServerMain {

	public static void main(String[] args) {
		
		//服务器节点，去连接网关
		INetService establishNetServiceToAgentService = ServerHelper.establishNetServiceToAgentService("127.0.0.1", AgentMain.SERVER_AGENT_PORT);
		establishNetServiceToAgentService.open();
		
		
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
