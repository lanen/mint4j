package evanq.net1;

import java.io.IOException;
import java.net.Socket;

/**
 * 
 * 这是最典型的处理网络数据方式
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DemoHandler implements Runnable {
	
	//客户端
	final Socket socket;

	static final int MAX_INPUT = 2048;
	
	public DemoHandler(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try{
			//step 1. read
			//缓存区，动态扩展。
			byte[] input = new byte[MAX_INPUT]	;
			socket.getInputStream().read(input);
			
			//step 2. decode
			
			//step 3. process
			
			//step 4. encode
			//事件多路分离
			byte[] output = process(input);
			
			//step 5. write
			//写数据
			socket.getOutputStream().write(output);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private byte[] process(byte[] input){
		return new byte[1];
	}

}
