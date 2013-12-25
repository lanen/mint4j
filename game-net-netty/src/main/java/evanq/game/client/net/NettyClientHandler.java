package evanq.game.client.net;

import evanq.game.net.PacketConst;
import evanq.game.net.packets.CRequestConnection;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelActive(ctx);
		System.out.println("NettyClientHandler.channelActive()");
		
		
		//发送激活数据		
		CRequestConnection requestConnection = new CRequestConnection();
		requestConnection.setPacketId(PacketConst.C_CONNECT_REQUEST);
		//ctx.write(requestConnection);
		ctx.writeAndFlush(requestConnection);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		// TODO Auto-generated method stub
		super.channelRead(ctx, msg);
		System.out.println("NettyClientHandler.channelRead()");
	}

}
