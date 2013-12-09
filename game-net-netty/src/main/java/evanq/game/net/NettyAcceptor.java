package evanq.game.net;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class NettyAcceptor implements INetInterface{

	private INetHandler handler;
	
	public NettyAcceptor(INetHandler handler){
		this.handler = handler;
	}
	
	@Override
	public int open() {
		System.out.println("NettyAcceptor.open()");
		return 0;
	}

	@Override
	public int close() {
		System.out.println("NettyAcceptor.close()");
		return 0;
	}

	@Override
	public int work() {
		System.out.println("NettyAcceptor.work()");
		
		return 0;
	}

}
