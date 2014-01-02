package evanq.game.net;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import evanq.game.concurrent.loop.ICommand;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
class NettyNetConnectionManagerAdaptor {

	private AbstractNetConnectionManager netConnectionManager;
	
	NettyNetConnectionManagerAdaptor(AbstractNetConnectionManager netConnectionManager){
		this.netConnectionManager = netConnectionManager;
	}
	
	private static final AttributeKey<INetConnection> NETCONNECTION_ATTR = AttributeKey.valueOf("net");
	
	public INetConnection get(Channel channel){
		Attribute<INetConnection> attr = channel.attr(NETCONNECTION_ATTR);
		return attr.get();
	}
	
	public void accpet(Channel channel){
		
		NewChannelAcceptCommand command = new NewChannelAcceptCommand();
		command.channel = channel;
		command.execute();
		//netConnectionManager.singleThread().accept(command);
		
	}
	
	public void close(Channel channel){
		ChannelDeActiveCommand command = new ChannelDeActiveCommand();
		command.channel = channel;
		command.execute();
//		netConnectionManager.singleThread().accept(command);
	}
	
	//TODO 是否使用单线程来管理连接
	class NewChannelAcceptCommand implements ICommand{
		Channel channel;
		@Override
		public void execute() {
		
			NettyConnection nc = new NettyConnection(channel);
			Attribute<INetConnection> attr = channel.attr(NETCONNECTION_ATTR);
			attr.set(nc);
			
			netConnectionManager.accpet(nc);
		}
		
	}
	
	class ChannelDeActiveCommand implements ICommand{
		Channel channel;
		@Override
		public void execute() {
			
			INetConnection iNetConnection = get(channel);
			if (null != iNetConnection) {
				netConnectionManager.close(iNetConnection);
			}
		}
		
	}

}
