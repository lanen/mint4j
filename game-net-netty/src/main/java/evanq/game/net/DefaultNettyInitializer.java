package evanq.game.net;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
class DefaultNettyInitializer extends AbstractNettyChannelInitializer  {
	
	/////定义各种编码器的名称
	static final String ZIP_ENCODER = "zipEnoder";
	static final String ZIP_DECODER = "zipDecoder";
	
	
	static final String DEFAULT_DECODER_LENGTH = "beforDecoder";
	static final String DEFAULT_DECODER = "decoder";
	
	static final String DEFAULT_ENCODER_LENGTH_APPENDER = "lastEncoder";
	static final String DEFAULT_ENCODER = "encoder";
	
	static final String AGENT_PACKET_ENCODER_LENGTH_APPENDER = "agent_encoder_length_appender";
	static final String AGENT_PACKET_ENCODER = "agent_encoder";
	
	static final String AGENT_PACKET_DECODER_LENGTH = "agent_decoder_length";
	static final String AGENT_PACKET_DECODER = "agent_decoder";
	
	static final String HANDLER = "handler";
	
	private INetServiceHandler netServiceHandler;
	
	public DefaultNettyInitializer(INetServiceHandler netServiceHandler) {
		this.netServiceHandler = netServiceHandler;
	}
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		
		ChannelPipeline pipeline = ch.pipeline();

		// 压缩算法

		// 加密算法

		// 解码器
		pipeline.addLast(DEFAULT_DECODER_LENGTH, new LengthFieldBasedFrameDecoder(2048,0, 4, 0, 4));
		pipeline.addLast(DEFAULT_DECODER, new DefaultNettyDecoder(this.netServiceHandler.packetAllocator()));	

		pipeline.addLast(DEFAULT_ENCODER_LENGTH_APPENDER, new LengthFieldPrepender(4));
		pipeline.addLast(DEFAULT_ENCODER, new DefaultNettyEncoder());

		// 处理器
		pipeline.addLast(HANDLER, new DefaultNettyHandler(wrapNetConnectionManager()));

	}
	
	private NettyNetConnectionManagerAdaptor wrapNetConnectionManager(){
		
		AbstractNetConnectionManager ancn = (AbstractNetConnectionManager)this.netServiceHandler.netConnectionManager();
		
		return new NettyNetConnectionManagerAdaptor(ancn,this);
		
	}

	@Override
	public void enableChannel(NetConnectionType connectionType, Channel ch)
			throws Exception {
		if(null == connectionType)return;
		if(null == ch)return;
		
		ChannelPipeline pipeline = ch.pipeline();

		switch (connectionType) {
		case NODE_IN_AGENT_CHAT:
		case NODE_IN_AGENT_LOGINSERVER:
		case NODE_IN_AGENT_NPC:
		case NODE_IN_AGENT_SCENE:
			
			pipeline.addBefore(DEFAULT_DECODER_LENGTH, AGENT_PACKET_DECODER_LENGTH, new LengthFieldBasedFrameDecoder(2048,0, 4, 0, 4));
			pipeline.addBefore(DEFAULT_DECODER_LENGTH, AGENT_PACKET_DECODER, new AgentNettyDecoder(netServiceHandler));
			
			pipeline.addBefore(DEFAULT_ENCODER_LENGTH_APPENDER, AGENT_PACKET_ENCODER, new AgentNettyEncoder());
			pipeline.addBefore(DEFAULT_ENCODER_LENGTH_APPENDER, AGENT_PACKET_ENCODER_LENGTH_APPENDER, new LengthFieldPrepender(4));
		
			
			break;
		default:
			break;
		}
		
	}

}
