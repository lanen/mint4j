package evanq.net3;

import evanq.game.net.INetInterface;
import evanq.game.net.NetInterfaceFactory;
import evanq.game.net.option.AcceptorOption;

public class NettyDemo {

	public static void main(String[] args) {
		
		
		AcceptorOption opt = new AcceptorOption();
		
		INetInterface netty = NetInterfaceFactory.getNetInterface(opt);
		
		netty.open();
		netty.work();
		netty.close();
	}
}
