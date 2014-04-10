package evanq.game.infrastructure.mint.commandexecutors.annotation;

import java.io.IOException;

import evanq.game.net.AbstractPacket;
import evanq.game.net.io.DataReader;
import evanq.game.net.io.DataWriter;

public final class DummyPacket extends AbstractPacket {

	private DummyPacket(){
		
	}
	
	@Override
	public void execute() {
		
	}

	@Override
	public void writeObject(DataWriter out) throws IOException {
		
	}

	@Override
	public void readObject(DataReader reader) throws IOException {
	}

	@Override
	protected StringBuffer toStringBuffer() {
		// TODO Auto-generated method stub
		return null;
	}

}
