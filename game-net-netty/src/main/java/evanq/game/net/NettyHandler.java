package evanq.game.net;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.SimpleChannelInboundHandler;

class NettyHandler extends SimpleChannelInboundHandler<IPacket> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IPacket msg)
			throws Exception {
		System.out.println("NettyHandler.channelRead0()");
		System.out.println(ctx.channel().remoteAddress());
		
		msg.execute();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
		System.out.println("NettyHandler.exceptionCaught()");
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		NettyConnection nc = new NettyConnection(ctx.channel());
		nc.onAccepted();		
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelInactive(ctx);
		Channel channel = ctx.channel();
		
		System.out.println(channel);
		System.out.println("NettyHandler.channelInactive()");
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelReadComplete(ctx);
		System.out.println("NettyHandler.channelReadComplete()");
		
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelRegistered(ctx);
		System.out.println("NettyHandler.channelRegistered()");
		
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelUnregistered(ctx);
		System.out.println("NettyHandler.channelUnregistered()");
		
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx)
			throws Exception {
		// TODO Auto-generated method stub
		super.channelWritabilityChanged(ctx);
		System.out.println("NettyHandler.channelWritabilityChanged()");
		
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		// TODO Auto-generated method stub
		super.userEventTriggered(ctx, evt);
		System.out.println("NettyHandler.userEventTriggered()");
		
	}
	
	

}
