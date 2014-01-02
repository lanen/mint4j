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
class NettyHandler extends SimpleChannelInboundHandler<IPacket> {

	private NettyNetConnectionManagerAdaptor netConnectionManager;
	
	NettyHandler(NettyNetConnectionManagerAdaptor adptor) {
		netConnectionManager = adptor;
	}
		
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IPacket msg)
			throws Exception {
		
		INetConnection iNetConnection = netConnectionManager.get(ctx.channel());	
		if(null !=iNetConnection){
			msg.connection(iNetConnection);
			msg.execute();
		}else{
			throw new NullPointerException("不能到达这里");
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
		System.out.println(ctx.channel().toString());
		netConnectionManager.accpet(ctx.channel());	
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		netConnectionManager.close(ctx.channel());
	}

}
