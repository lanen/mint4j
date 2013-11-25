package evanq.game.net.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import evanq.game.net.AbstractNetInterface;
import evanq.game.net.INetInterface;
import evanq.game.net.INetInterfaceFactory;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class NettyNetInterfaceFactory implements INetInterfaceFactory {
	
	ConcurrentMap<String, INetInterface> mapping;
	
	public NettyNetInterfaceFactory(){
		mapping = new ConcurrentHashMap<String, INetInterface>();
	}
	
	@Override
	public INetInterface getNetInterface(String name) {
		
		INetInterface iNetInterface = mapping.get(name);
		if(null != iNetInterface){
		
			return iNetInterface;
		}else{
			if("agent".equals(name)){
				iNetInterface = new AbstractNetInterface();
			}
			mapping.put(name, iNetInterface);
			return iNetInterface;
		}
		
	}


}
