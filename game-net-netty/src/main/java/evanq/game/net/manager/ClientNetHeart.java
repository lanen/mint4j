package evanq.game.net.manager;

import evanq.game.net.INetConnection;
import evanq.game.net.INetHeart;
import evanq.game.net.PacketConst;
import evanq.game.net.packets.CHeartBeat;

/**
 * 
 * 客户端心跳
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ClientNetHeart implements INetHeart {

	private INetConnection connection;
	
	public ClientNetHeart(INetConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public void beat() {
		
		if(null == connection)return;
					
		CHeartBeat beatPacket = new CHeartBeat();
		beatPacket.setPacketId(PacketConst.C_HEART_BEAT);
		connection.send(beatPacket);
	}

	@Override
	public boolean isDead() {
		return false;
	}
	
}
