package evanq.game.cardgame.interfaces.dto;

import java.io.IOException;

import evanq.game.infrastructure.mint.AbstractDTO;
import evanq.game.net.NetPacketType;
import evanq.game.net.io.DataReader;
import evanq.game.net.io.DataWriter;

public class LogoutDTO extends AbstractDTO {

	protected LogoutDTO( ) {
		super(NetPacketType.CLIENT);
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
