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
	
	/**
	 * 将协议号=> 协议类 注册到IPacketAllocator 中
	 * @param packetId
	 * @param clazz
	 */
	public static void R(int packetId, Class<? extends AbstractPacket> clazz){
		Singleton.INSTANCE.registerPacketSchema(packetId, clazz);		
	}
	
	/**
	 * 
	 * 申请一个 指定类型的空包。
	 * 
	 * @param clazz
	 */
	@SuppressWarnings("unchecked")
	public static <E> E newPacket(Class<? extends IPacket> clazz){
		
		int packetId = Singleton.INSTANCE.getPacketId(clazz);
		if(packetId>0){
			try {
				AbstractPacket newInstance = (AbstractPacket)clazz.newInstance();
				
				newInstance.setPacketId(packetId);
				//TODO 根据PacketId 编号，决定数据包类型
				return (E) newInstance;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
