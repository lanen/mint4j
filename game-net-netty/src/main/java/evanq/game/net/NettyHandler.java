package evanq.game.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

class NettyHandler extends SimpleChannelInboundHandler<IPacket> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IPacket msg)
			throws Exception {
		System.out.println("NettyHandler.channelRead0()");
		NettyConnection.messageReceived(msg);
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
		nc.onConnected();	
		
		//TODO 新建连接
		
		//TODO 交给管理组
		
		//TODO 连接进行验证
		
		//TODO 验证完毕，将连接交给holder
		
		
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		
		NettyDisconnection dis = new NettyDisconnection(ctx.channel());
		dis.onDisconnected();
	}


	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		// TODO Auto-generated method stub
		super.userEventTriggered(ctx, evt);
		System.out.println("NettyHandler.userEventTriggered()");
		
	}
	
	

}
