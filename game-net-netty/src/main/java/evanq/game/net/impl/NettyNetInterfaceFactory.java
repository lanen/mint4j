package evanq.game.net.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import evanq.game.net.AgentHandler;
import evanq.game.net.INetInterface;
import evanq.game.net.INetInterfaceFactory;
import evanq.game.net.INetOption;
import evanq.game.net.NettyAcceptor;
import evanq.game.net.option.AcceptorOption;
import evanq.game.net.option.ConnectorOption;

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
			AgentHandler handler = new AgentHandler();
			NettyAcceptor acc_   = new NettyAcceptor(handler);
			return acc_;
		}else if(optional instanceof ConnectorOption){
			
		}else{
			
		}
		return null;
	}

}
