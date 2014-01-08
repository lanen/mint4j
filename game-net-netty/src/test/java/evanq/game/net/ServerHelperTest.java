package evanq.game.net;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import evanq.game.utils.Sleeper;
@RunWith(JUnit4.class)
public class ServerHelperTest {

	@Test
	public void test() {
		
		//listen client
		INetService agent4Client = ServerHelper.create(NetServiceType.AGENT_CLIENT, 10000);
		agent4Client.open();
		
		INetService agent4Server = ServerHelper.create(NetServiceType.AGENT_SERVER, 6000);
		agent4Server.open();
		
		
		Sleeper.sleep();
		
	}

}
