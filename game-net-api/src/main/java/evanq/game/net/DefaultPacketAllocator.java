package evanq.game.net;


/**
 * @author Evan cppmain@gmail.com
 *
 */
public final class DefaultPacketAllocator extends AbstractPacketAllocator {

	private static class Singleton {
		public static DefaultPacketAllocator INSTANCE = new DefaultPacketAllocator();
	}

	public static DefaultPacketAllocator getInstance() {
		return Singleton.INSTANCE;
	}

	private DefaultPacketAllocator() {
	}
	
	public static void R(int packetId, Class<? extends AbstractPacket> clazz){
		Singleton.INSTANCE.registerPacketSchema(packetId, clazz);		
	}
	
}
