package evanq.game.net;

import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
class DefaultNettyInitializer extends AbstractNettyInitializer  {
		
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
		pipeline.addLast("beforDecoder", new LengthFieldBasedFrameDecoder(2048,0, 4));
		pipeline.addLast("decoder", new DefaultNettyDecoder(this.netServiceHandler.packetAllocator()));		

		pipeline.addLast("lastEncoder", new LengthFieldPrepender(4));
		pipeline.addLast("encoder", new DefaultNettyEncoder());

		// 处理器
		pipeline.addLast("handler", new DefaultNettyHandler(wrapNetConnectionManager()));

	}
	
	private NettyNetConnectionManagerAdaptor wrapNetConnectionManager(){
		
		AbstractNetConnectionManager ancn = (AbstractNetConnectionManager)this.netServiceHandler.netConnectionManager();
		
		return new NettyNetConnectionManagerAdaptor(ancn);
		
	}
	

}
