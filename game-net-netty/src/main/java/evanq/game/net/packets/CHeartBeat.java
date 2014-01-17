package evanq.game.net.packets;

import java.io.IOException;

import evanq.game.net.AbstractPacket;
import evanq.game.net.NetConnectionEvent;
import evanq.game.net.NetPacketType;
import evanq.game.net.io.DataReader;
import evanq.game.net.io.DataWriter;

/**
 * 
 * 客户单的心跳包
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class CHeartBeat extends AbstractPacket{

	public CHeartBeat() {
		super(NetPacketType.CLIENT);
	}
	
	@Override
	public void execute() {
		//服务端收到心跳包
		connection().fsm().fireEvent(NetConnectionEvent.PING);
	}

	@Override
	public void writeObject(DataWriter out) throws IOException {
		
		
	}

	@Override
	public void readObject(DataReader reader) throws IOException {
		
	}

	@Override
	protected StringBuffer toStringBuffer() {
		return null;
	}

}
