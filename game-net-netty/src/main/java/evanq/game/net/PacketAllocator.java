package evanq.game.net;

import evanq.game.net.packets.CHeartBeat;
import evanq.game.net.packets.CRequestConnection;
import evanq.game.net.packets.SRequestConnection_OK;

public final class PacketAllocator extends AbstractPacketAllocator {

	
	private static class Singleton {
		public static PacketAllocator INSTANCE = new PacketAllocator();
	}
	
	private PacketAllocator(){
		super();
	}
	
	public static PacketAllocator getInstance(){
		return Singleton.INSTANCE;
	}
	
	private boolean registered = false;
	public void R(int packetId, Class<? extends AbstractPacket> clazz){
		registerPacketSchema(packetId, clazz);
	}
	
	public void doRegister(){
		
		if (registered) {
			System.out.println("PacketAllocator.doRegister() has registered");
			return;
		}
		
		registered = true;
		R(PacketConst.C_CONNECT_REQUEST, CRequestConnection.class);
		R(PacketConst.S_CONNECT_REQUEST_OK, SRequestConnection_OK.class);
		R(PacketConst.C_HEART_BEAT, CHeartBeat.class);
	}
	
}
