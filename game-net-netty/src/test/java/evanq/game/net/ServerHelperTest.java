package evanq.game.net;

import org.junit.Test;

public class ServerHelperTest {

	@Test
	public void test() {
		
		
		INetService agent = ServerHelper.create(NetServiceType.AGENT_SERVER, 10000);
		
	}

}
