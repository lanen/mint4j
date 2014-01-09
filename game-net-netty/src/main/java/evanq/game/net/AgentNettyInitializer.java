package evanq.game.net;

import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 
 * 这是转发型的服务器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class AgentNettyInitializer extends AbstractNettyInitializer {

	private INetConnectionManager manager;
	private AbstractPacketAllocator packetAllocator;
	
	public AgentNettyInitializer(INetConnectionManager manager,AbstractPacketAllocator packetAllocator) {
		this.manager = manager;
		this.packetAllocator=packetAllocator;
	}
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		
		ChannelPipeline pipeline = ch.pipeline();

		// 压缩算法

		// 加密算法

		// 解码器
		pipeline.addLast("beforDecoder", new LengthFieldBasedFrameDecoder(2048,0, 4));
		pipeline.addLast("lastEncoder", new LengthFieldPrepender(4));
		
		pipeline.addLast("decoder", new AgentNettyDecoder(this.packetAllocator));		
		pipeline.addLast("encoder", new AgentNettyEncoder());

		// 处理器
		pipeline.addLast("handler", new DefaultNettyHandler(new NettyNetConnectionManagerAdaptor((AbstractNetConnectionManager)manager)));

	}

}
