package evanq.game.net;

/**
 * 
 * 专门针对网络包的代码
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class AbstractNetInterface implements INetInterface {

	@Override
	public int open() {
		System.out.println("open");
		return 0;
	}

	@Override
	public int close() {
		System.out.println("close");

		return 0;
	}

	@Override
	public int work() {
		
		System.out.println("work");
		return 0;
	}

}
