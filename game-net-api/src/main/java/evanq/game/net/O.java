package evanq.game.net;

import java.io.IOException;

public class O extends AbstractPacket {

	private String a;
	
	@Override
	public void handleImpl() {
		// TODO Auto-generated method stub

		System.out.println("O.handleImpl()");
	}

	@Override
	public void writeObject(OutputSerializer out) throws IOException {
		out.write(a);
	}

	@Override
	public void readObject(InputSerializer in) throws IOException {
		a = in.read65536LongString();
	}

}
