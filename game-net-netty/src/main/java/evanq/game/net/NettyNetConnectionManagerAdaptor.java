package evanq.game.net;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import evanq.game.concurrent.loop.ICommand;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;
import evanq.game.trace.TraceConstant;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
class NettyNetConnectionManagerAdaptor {

	private Trace logger = LogSystem.getDefaultTrace(TraceConstant.CONNECTION);
	
	private AbstractNetConnectionManager netConnectionManager;
	private AbstractNettyChannelInitializer channelInitializer;
	NettyNetConnectionManagerAdaptor(AbstractNetConnectionManager netConnectionManager,AbstractNettyChannelInitializer channelInitializer){
		this.netConnectionManager = netConnectionManager;
		this.channelInitializer = channelInitializer;
	}
	
	static final AttributeKey<INetConnection> NETCONNECTION_ATTR = AttributeKey.valueOf("NetConnection");
	static final AttributeKey<NetConnectionType> NETCONNECTION_TYPE_ATTR = AttributeKey.valueOf("NetConnectionType");
	
	//控制是否在单线程中执行业务
	private static final boolean COMMAND_ON_SINGLE_THREAD = true;
	
	public INetConnection get(Channel channel){
		Attribute<INetConnection> attr = channel.attr(NETCONNECTION_ATTR);
		return attr.get();
	}
	
	public NetConnectionType getChannelType(Channel channel){
		Attribute<NetConnectionType> attr = channel.attr(NETCONNECTION_TYPE_ATTR);
		return attr.get();
	}
	
	public void accpet(Channel channel){
		
		NewChannelAcceptCommand command = new NewChannelAcceptCommand();
		command.channel = channel;
	
		if (COMMAND_ON_SINGLE_THREAD) {
			netConnectionManager.singleThread().accept(command);
		}else{
			command.execute();
		}
	}
	
	public void close(Channel channel){
		ChannelDeActiveCommand command = new ChannelDeActiveCommand();
		command.channel = channel;
		if (COMMAND_ON_SINGLE_THREAD) {
			netConnectionManager.singleThread().accept(command);
		}else{
			command.execute();
		}
 
	}
	
	public void initChannel(NetConnectionType type, Channel channel){

		try {
			channelInitializer.enableChannel(type, channel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void message(Channel channel, IPacket msg){
		
		ChannelMessageCommand command = new ChannelMessageCommand();
		command.channel = channel;
		command.msg = msg;
		
		if (COMMAND_ON_SINGLE_THREAD) {
			netConnectionManager.singleThread().accept(command);
		}else{
			command.execute();
		}
	}
	
	//TODO 是否使用单线程来管理连接
	class NewChannelAcceptCommand implements ICommand{
		Channel channel;
		
		@Override
		public void execute() {
			
			NetConnectionType type = getChannelType(channel);
		
			logger.info("A dummy NetConnection Accepted with Channel:{},type:{}",channel,type);
			
			NettyConnection nc = new NettyConnection(channel, type,NettyNetConnectionManagerAdaptor.this);
			Attribute<INetConnection> attr = channel.attr(NETCONNECTION_ATTR);
			attr.set(nc);
			
			netConnectionManager.accpet(nc);
			
		}
		
	}
	
	//TODO 断开连接
	class ChannelDeActiveCommand implements ICommand {
		Channel channel;
		@Override
		public void execute() {
			
			INetConnection iNetConnection = get(channel);
			if (null != iNetConnection) {
				netConnectionManager.close(iNetConnection);
			}
		}		
	}
	
	class ChannelMessageCommand implements ICommand{
		
		Channel channel;
		IPacket msg;
		@Override
		public void execute() {
			
			INetConnection iNetConnection = get(channel);	
			if(null !=iNetConnection){

				//try 防止异常崩坏线程
				try{
					msg.connection(iNetConnection);
					msg.execute();
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				throw new NullPointerException("不能到达这里");
			}

		}
		
	}

}
