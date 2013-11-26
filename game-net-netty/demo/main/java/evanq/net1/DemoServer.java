package evanq.net1;

import java.io.IOException;
import java.net.ServerSocket;

public class DemoServer implements Runnable{
	
	private int port;
	
	public DemoServer(int port){
		this.port = port;
	}
	@Override
	public void run() {
	
		try {
			ServerSocket ss = new ServerSocket(this.port);
			
			//TODO 单线程或线程池
			while( ! Thread.interrupted()){
				Thread t = new Thread(new DemoHandler(ss.accept()));
				t.start();
			}
			
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
