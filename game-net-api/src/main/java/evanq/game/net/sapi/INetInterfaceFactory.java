package evanq.game.net.sapi;


/**
 * @author Evan cppmain@gmail.com
 *
 */
public interface INetInterfaceFactory {
	
	/**
	 * @param name
	 * @return
	 */
	public INetInterface getNetInterface(INetOption optional);
	
}
