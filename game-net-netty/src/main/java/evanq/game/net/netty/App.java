package evanq.game.net.netty;

import evanq.game.net.AbstractNetInterface;
import evanq.game.net.INetInterface;
import evanq.game.net.NetInterfaceFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args )
    {
    	
    	INetInterface netInterface = NetInterfaceFactory.getNetInterface(AbstractNetInterface.class);
    	
    	netInterface.open();
    	netInterface.work();
    	netInterface.close();
    }
}
