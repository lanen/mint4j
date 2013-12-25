package evanq.game.net;

public interface IPacketAllocator<PACKET_SCHEMA,PACKET> {

	public void registerPacketSchema(int packetId,PACKET_SCHEMA clazz);
	
	public PACKET_SCHEMA getSchema(int packetId);
	
	public PACKET newPacket(int packetId) throws PacketSchemaException;
	
}
