package evanq.game.net.agent;

import evanq.game.net.Agent;

public class AgentMain {

	
	public static final int CLIENT_AGENT_PORT = 10000;
	public static final int SERVER_AGENT_PORT = 7000;
	
	
	public static void main(String[] args) {
		
		//建立一个网关服务器
		Agent agent = new Agent();
		agent.setClientAgentPort(10000);
		agent.setServerAgentPort(7000);
		
		agent.bind();
		
		agent.start();
		
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
