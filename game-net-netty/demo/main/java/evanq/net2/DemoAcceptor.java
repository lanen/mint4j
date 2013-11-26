package evanq.net2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DemoAcceptor  implements Runnable{
	
	static final int MAXIN = 1024;
	static final int MAXOUT= 1024;

	private ServerSocketChannel serverSocket;
	private Selector selector ;
	public DemoAcceptor(Selector selector,ServerSocketChannel serverSocket){
		this.selector=selector;
		this.serverSocket = serverSocket;
	}
	
	@Override
	public void run() {
		try {
			SocketChannel accept = serverSocket.accept();
			if(null !=accept){
				new Hander(selector,accept);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class Hander implements Runnable {
		
		private SocketChannel socket;
		private Selector selector;
		
		//客户端
		private SelectionKey selectionKey;
		
		
		//// member for read ,write
		ByteBuffer input = ByteBuffer.allocate(MAXIN);
		ByteBuffer output = ByteBuffer.allocate(MAXOUT);
		
		////state of handle
		static final int READING = 0;
		static final int WRITTING=1;
		
		int state = READING;
		
		public Hander(Selector selector,SocketChannel socket) throws IOException{
			this.selector = selector;
			this.socket= socket;
			
			
			this.socket.configureBlocking(false);
			selectionKey = this.socket.register(this.selector, 0);
			selectionKey.attach(this);
			selectionKey.interestOps(SelectionKey.OP_READ);
			
			//唤醒，因为有新的连接进来
			
			this.selector.wakeup();
		}

		@Override
		public void run() {
			
			try{
				
				if(READING == this.state){
					System.out.println("read");
					read();
				}else if(WRITTING == this.state){
					System.out.println("write");
					write();
				}
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		boolean inputIsComplete(){
			return true;
		}
		
		boolean outputIsComplete(){
			return true;
		}
		
		void process(){
			System.out.println("DDDDDD");
		}
		
		void read() throws IOException{
			socket.read(input);
			if(inputIsComplete()){
				process();
				state = WRITTING;
				
				selectionKey.interestOps(SelectionKey.OP_WRITE);
			}
		}
		
		void write() throws IOException{
			socket.write(output);
			//发送完毕，取消
			if(outputIsComplete()){
				selectionKey.cancel();
			}
		}
	}
}
