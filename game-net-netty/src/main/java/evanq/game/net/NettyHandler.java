package evanq.game.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

class NettyHandler extends SimpleChannelInboundHandler<IPacket> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IPacket msg)
			throws Exception {
		System.out.println("NettyHandler.channelRead0()");
		msg.handleImpl();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}
	
	

}
