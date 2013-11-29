package evanq.game.net.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import evanq.game.net.INetInterface;
import evanq.game.net.INetInterfaceFactory;
import evanq.game.net.INetOption;

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
		
		INetInterface iNetInterface = mapping.get(optional);
		if(null != iNetInterface){
		
			return iNetInterface;
		}else{
			
			//在这里进行具体的初始化
			
			return null;
		}
	}

}
