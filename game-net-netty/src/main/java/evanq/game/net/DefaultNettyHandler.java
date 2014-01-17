package evanq.game.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 
 * 将IO 的控制权转给 {@link INetConnectionManager}
 * 
 * @see INetConnectionManager
 * 
 * @author Evan cppmain@gmail.com
 *
 */
class DefaultNettyHandler extends SimpleChannelInboundHandler<IPacket> {

	NettyNetConnectionManagerAdaptor netConnectionManager;
	
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
