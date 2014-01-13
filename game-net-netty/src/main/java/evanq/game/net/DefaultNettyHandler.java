package evanq.game.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 
 * 来自客户端的数据（读写），连接（开/关）处理器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DefaultNettyHandler extends SimpleChannelInboundHandler<IPacket> {

	private NettyNetConnectionManagerAdaptor netConnectionManager;
	
	DefaultNettyHandler(NettyNetConnectionManagerAdaptor adptor) {
		netConnectionManager = adptor;
	}
		
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IPacket msg)
			throws Exception {
		netConnectionManager.message(ctx.channel(), msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		super.exceptionCaught(ctx, cause);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {		
		netConnectionManager.accpet(ctx.channel());	
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		netConnectionManager.close(ctx.channel());
	}

}
