package evanq.game.net;

/**
 * @author Evan cppmain@gmail.com
 *
 * @param <PACKET_SCHEMA>
 * @param <PACKET>
 */
public interface IPacketAllocator<PACKET_SCHEMA,PACKET> {

	public void registerPacketSchema(int packetId,PACKET_SCHEMA clazz);
	
	public PACKET_SCHEMA getSchema(int packetId);
	
	public PACKET newPacket(int packetId) throws PacketSchemaException;
	
}
