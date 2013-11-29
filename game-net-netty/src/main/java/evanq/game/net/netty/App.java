package evanq.game.net.netty;

import evanq.game.net.INetInterface;
import evanq.game.net.INetOption;
import evanq.game.net.NetInterfaceFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args )
    {
    	
    	INetInterface netInterface = NetInterfaceFactory.getNetInterface(new INetOption() {
		});
    	
    	netInterface.open();
    	netInterface.work();
    	netInterface.close();
    }
}
