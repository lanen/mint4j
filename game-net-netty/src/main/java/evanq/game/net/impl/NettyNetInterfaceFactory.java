package evanq.game.net.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import evanq.game.net.option.AcceptorOption;
import evanq.game.net.option.ConnectorOption;
import evanq.game.net.sapi.INetInterface;
import evanq.game.net.sapi.INetInterfaceFactory;
import evanq.game.net.sapi.INetOption;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class NettyNetInterfaceFactory implements INetInterfaceFactory {
	
	ConcurrentMap<INetOption, INetInterface> mapping;
	
	public NettyNetInterfaceFactory(){
		mapping = new ConcurrentHashMap<INetOption, INetInterface>();
	}
	
	@Override
	public INetInterface getNetInterface(INetOption optional) {
		
		if(optional instanceof AcceptorOption){
		
		}else if(optional instanceof ConnectorOption){
			
		}else{
			
		}
		return null;
	}

}
