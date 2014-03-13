package evanq.game.cardgame.interfaces.mint;

import evanq.game.net.AbstractPacket;
import evanq.game.net.NetPacketType;

public abstract class DTO extends AbstractPacket {

	protected DTO(NetPacketType packetType) {
		super(packetType);
	}

	@Override
	public void execute() {	
	}
	

}
