package evanq.game.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

class NettyHandler extends SimpleChannelInboundHandler<IPacket> {

	private NettyNetConnectionManagerAdaptor netConnectionManager;
	
	NettyHandler(NettyNetConnectionManagerAdaptor adptor) {
		netConnectionManager = adptor;
	}
	
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IPacket msg)
			throws Exception {
		System.out.println("NettyHandler.channelRead0()");
		INetConnection iNetConnection = netConnectionManager.get(ctx.channel());
	
		if(null !=iNetConnection){
			
			msg.connection(iNetConnection);
			msg.execute();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		super.exceptionCaught(ctx, cause);
		System.out.println("NettyHandler.exceptionCaught()");
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
