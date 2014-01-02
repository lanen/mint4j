package evanq.game.net;

import io.netty.channel.Channel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import evanq.game.net.packets.CRequestConnection;

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
		
			
		try {
			wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//客户端
		client = new NetServiceAdaptor(NetServiceType.CLIENT,"127.0.0.1",8001,null);
		client.addStartListener(new INetStartListener() {
			
			@Override
			public void onStart(Channel channel_) {				
				System.out.println("客户端连接完毕");
				
				flag = CLIENT_STARTED;
				
				channel = channel_;
				event = EVENT_CONNECT_OPEN;
			}
		});
		
		client.open();

	}
	
	
	@After
	public void tearDown(){
		server.close();
		client.close();
	}
	
	
	@Test
	public void testConnection() {
		
		while( ! client.isOpen() ){
			whileFor0();
			break;
		}
	}
	
	private static final int CLIENT_STARTED  = 1;
	
	private static final int CLIENT_CLOSEING = 2;
	
	private int flag;
	
	//连接状态循环
	private synchronized void whileFor0(){
		System.out.println(flag);
		while(client.isOpen()){
			
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
			channel.writeAndFlush(requestConnection);
		}
			break;
		}
	}
	

}
