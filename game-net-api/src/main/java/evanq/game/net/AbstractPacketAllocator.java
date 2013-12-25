package evanq.game.net;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractPacketAllocator implements IPacketAllocator<Class<? extends AbstractPacket>,AbstractPacket>{
	
	protected Map<Integer,Class<? extends AbstractPacket>> packetSchema ;
	
	protected AbstractPacketAllocator() {
		this.packetSchema = newPacketSchemaMap();
		
	}
	
	protected Map<Integer,Class<? extends AbstractPacket>> newPacketSchemaMap(){
		return new HashMap<Integer,Class<? extends AbstractPacket>>();
	}
	@Override
	public void registerPacketSchema(int packetId, Class<? extends AbstractPacket> clazz) {

		if(null == clazz){
			throw new NullPointerException("clazz");
		}
		if(packetId<0){
			throw new IllegalAccessError("packetId 必须是正整数");
		}
		
		if( null == packetSchema ){
			throw new NullPointerException("packetSchema");
		}
		
		if( packetSchema.containsKey(packetId) ){
			throw new IllegalAccessError("重复的packetId:"+packetId);
		}

		packetSchema.put(packetId, clazz);
	}

	@Override
	public Class<? extends AbstractPacket> getSchema(int packetId) {
		return packetSchema.get(packetId);
	}

	@Override
	public AbstractPacket newPacket(int packetId) throws PacketSchemaException {
		Class<? extends AbstractPacket> schema = getSchema(packetId);
		
		if(null == schema){
			throw new PacketSchemaException(packetId+ " 找不到");
		}
		
		try {
			AbstractPacket newInstance = schema.newInstance();
			newInstance.setPacketId((char)packetId);
			return newInstance;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
