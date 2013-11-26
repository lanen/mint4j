package evanq.net2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

/**
 * 
 * 反应堆的概念实现
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DemoReactor  implements Runnable{

	private int port ;
	
	final Selector selector;
	
	final ServerSocketChannel serverSocket;
	
	public DemoReactor(int port) throws IOException{
		this.port=port;
		
		selector = Selector.open();
		serverSocket=ServerSocketChannel.open();
		
		serverSocket.socket().bind(new InetSocketAddress(this.port));
		serverSocket.configureBlocking(false);
		
		SelectionKey selectKey = serverSocket.register( selector,SelectionKey.OP_ACCEPT);
		
		DemoAcceptor acceptor =new DemoAcceptor(selector, serverSocket);
		selectKey.attach(acceptor);
	}
	
	private void impl2( ) throws IOException{
		
		//使用默认提供的实现
		SelectorProvider sp = SelectorProvider.provider();
		Selector openSelector = sp.openSelector();
		ServerSocketChannel openServerSocketChannel = sp.openServerSocketChannel();
	}
	
	@Override
	public void run() {
		
		try {
			while (!Thread.interrupted()) {

				selector.select();
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				for (SelectionKey selectionKey : selectedKeys) {
					dispatch(selectionKey);
				}
				selectedKeys.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void dispatch(SelectionKey selectionKey){
		Runnable run = (Runnable)selectionKey.attachment();
		if(null != run){
			run.run();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			DemoReactor d = new DemoReactor(10001);
			new Thread (d).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
