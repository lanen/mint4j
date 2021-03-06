package evanq.game.net;

import io.netty.channel.Channel;
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

	//控制是否在单线程中执行业务
	private static final boolean COMMAND_ON_SINGLE_THREAD = true;
		
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
		delayClose(channel,false);
		
	}
	
	/**
	 * 
	 * @param channel
	 * @param delayClose true enable delay close
	 */
	public void delayClose(Channel channel,boolean delayClose){
		ChannelDeActiveCommand command = new ChannelDeActiveCommand();
		command.channel = channel;
		command.delayClose=delayClose;
		if (COMMAND_ON_SINGLE_THREAD) {
			netConnectionManager.singleThread().accept(command);
		}else{
			command.execute();
		}
 
	}
	
	public void broken(Channel channel){
		delayClose(channel,true);
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
		
			logger.info("A dummy NetConnection Accepted with Channel:{}",channel);			
			
			NettyConnection nc = new NettyConnection(channel, NetConnectionType.DUMMY);
			AbstractNettyChannelInitializer.set(channel,nc);
			
			nc.addPropertyChangeListener(channelInitializer);
			
			INetConnectionFSM fsm = netConnectionManager.createNetConnectionFSM(nc);
			fsm.fireEvent(NetConnectionEvent.CREATE_OK);			
			
		}
		
	}
	
	//TODO 断开连接
	class ChannelDeActiveCommand implements ICommand {
		
		Channel channel;
		boolean delayClose=false;
		@Override
		public void execute() {
			
			NettyConnection iNetConnection = AbstractNettyChannelInitializer.get(channel);
			if (null != iNetConnection) {
				if(delayClose){
					iNetConnection.fsm().fireEvent(NetConnectionEvent.DELAYED_CLOSE);					
				}else{
					iNetConnection.fsm().fireEvent(NetConnectionEvent.CLOSE);
					
				}
			}
			
			iNetConnection.removePropertyChangeListener(channelInitializer);

		}		
	}
	
	class ChannelMessageCommand implements ICommand{
		
		Channel channel;
		IPacket msg;
		@Override
		public void execute() {
			
			INetConnection iNetConnection = AbstractNettyChannelInitializer.get(channel);	
			if(null != iNetConnection){

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
