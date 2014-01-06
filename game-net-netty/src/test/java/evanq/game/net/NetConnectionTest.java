package evanq.game.net;

import io.netty.channel.Channel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import evanq.game.net.packets.CRequestConnection;
import evanq.game.trace.Trace;
import evanq.game.trace.LogSystem;
import evanq.game.trace.TraceConstant;

@RunWith(JUnit4.class)
public class NetConnectionTest {
	

	
	NetServiceAdaptor server ;
	NetServiceAdaptor client ;
	
	@Before
	public synchronized void setUp(){
		server = new NetServiceAdaptor(NetServiceType.SERVER,8001,null);
		server.addStartListener(new INetStartListener() {
			
			@Override
			public void onStart(Channel channel) {
				System.out.println("服务器启动完毕");
			}
			
		});
		server.open();
		
		
		
		//等待服务端启动完毕	
		
		client = new NetServiceAdaptor(NetServiceType.CLIENT,"127.0.0.1",8001,null);

	}
	
	
	@After
	public void tearDown(){
		server.close();
		client.close();
	}
	
	
	@Test
	public synchronized void testConnection() {
//		while( ! client.isOpen() ){
//			whileFor0();
//			break;
//		}
		//客户端
				
				client.addStartListener(new INetStartListener() {
					
					@Override
					public void onStart(Channel channel_) {				
						
						LogSystem logSystem = new LogSystem(TraceConstant.GAME_SYSTEM);
						Trace trace = logSystem.getTrace(NettyConnection.class);
						trace.info("客户端连接完毕");
						
						flag = CLIENT_STARTED;
						
						channel = channel_;
						event = EVENT_CONNECT_OPEN;
						
						whileFor0();
					}
				});
				client.open();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	
	private static final int CLIENT_STARTED  = 1;
	
	private static final int CLIENT_CLOSEING = 2;
	
	private int flag;
	
	//连接状态循环
	private synchronized void whileFor0(){
		while(true){
			
			switch(flag){
			case CLIENT_STARTED:
				data();
				event=0;
				break;
			case CLIENT_CLOSEING:
				break;
			}
			
			try {
				wait(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Channel channel;
	private int event;
	private static final int EVENT_CONNECT_OPEN = 1;
	
	//数据包状态循环
	private void data(){

		switch(event){
		
		case EVENT_CONNECT_OPEN:
		{
			//发送激活数据
			CRequestConnection requestConnection = new CRequestConnection();
			requestConnection.setPacketId(PacketConst.C_CONNECT_REQUEST);
			requestConnection.setAccessToken(999);
			requestConnection.setConnectionType(NetConnectionType.CLIENT_MASTER.value());
			channel.write(requestConnection);
			channel.flush();
				
		}
			break;
		}
	}
	

}
