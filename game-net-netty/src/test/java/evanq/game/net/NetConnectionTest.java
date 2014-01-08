package evanq.game.net;

import io.netty.channel.Channel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import evanq.game.net.packets.CRequestConnection;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;

@RunWith(JUnit4.class)
public class NetConnectionTest {
	
	private Trace logger = LogSystem.getDefaultTrace(NetConnectionTest.class);
	
	NetServiceAdaptor server ;
	NetServiceAdaptor client ;
	
	@Before
	public synchronized void setUp(){
		
		PacketAllocator.getInstance().doRegister();

		server = new NetServiceAdaptor(NetServiceType.SERVER,8081,null,PacketAllocator.getInstance());
		server.addChannelCreateListener(new IChannelCreateListener() {
			
			@Override
			public void onCreate(Channel channel) {
				
			}
			
		});
		server.open();
		
	}
	
	@After
	public void tearDown(){
		server.close();
		client.close();
	}
	
	
	@Test
	public synchronized void testConnection() {
	
		whileFor0();
	}
	
	private static final int CLIENT_STARTED  = 1;	
	private static final int CLIENT_OPENED = 2;
	private static final int CLIENT_CLOSED = 3;
	
	private int flag;
	
	//连接状态循环
	private synchronized void whileFor0(){
		flag = CLIENT_STARTED;
		while(true){
			
			switch(flag){
			case CLIENT_STARTED:
				create();
				flag=CLIENT_OPENED;
				break;
			case CLIENT_CLOSED:			
				return;
			case CLIENT_OPENED:
				data();
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
	private static final int EVENT_CONNECT_CLOSE = 2;
	
	
	private void create(){
		
		if(null != client)return;
		
		//等待服务端启动完毕			
		client = new NetServiceAdaptor(NetServiceType.CLIENT,"127.0.0.1",8081,null,PacketAllocator.getInstance());
		
		client.addChannelCreateListener(new IChannelCreateListener() {
			
			@Override
			public void onCreate(Channel channel_) {				
				
				logger.info("start client ,the channel is {}",channel_);
				
				channel = channel_;
				
				event = EVENT_CONNECT_OPEN;		
			}
		});
		client.open();
		
	}
	//数据包状态循环
	private void data(){
		int copyEvent = event;
		event = 0;
		switch(copyEvent){
		
		case EVENT_CONNECT_OPEN:
		{
			logger.info("发送CRequestConnection ");
			//发送激活数据
			CRequestConnection requestConnection = new CRequestConnection();
			requestConnection.setPacketId(PacketConst.C_CONNECT_REQUEST);
			requestConnection.setAccessToken(999);
			requestConnection.setConnectionType(NetConnectionType.CLIENT_MASTER.value());
			channel.write(requestConnection);
			channel.flush();				
					
			//
			event = EVENT_CONNECT_CLOSE;
			
		}
		break;
		case EVENT_CONNECT_CLOSE:{
			
			flag = CLIENT_CLOSED;
		}
		break;
		}
	}
	

}
