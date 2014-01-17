package evanq.game.net;

import java.io.IOException;

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

	NettyNetConnectionManagerAdaptor adaptor;
	
	DefaultNettyHandler(NettyNetConnectionManagerAdaptor adptor) {
		adaptor = adptor;
	}
		
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IPacket msg)
			throws Exception {
		adaptor.message(ctx.channel(), msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
//		System.out.println(ctx.channel().isActive()); //true
//		System.out.println(ctx.channel().isOpen());//true
//		System.out.println(ctx.channel().isRegistered());//true
//		System.out.println(ctx.channel().isWritable());//true
		
		if(cause instanceof IOException){
			adaptor.broken(ctx.channel());
		}else{
			super.exceptionCaught(ctx, cause);	
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		adaptor.accpet(ctx.channel());	
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {		
		adaptor.close(ctx.channel());
	}

}
