package evanq.game.net;

import io.netty.channel.Channel;

class NettyConnection implements INetConnection {

	//如何标示链接
	//思路来自linux对socket handle标记方式，每一个链接都作为一个file descriptor
	//map<connecion,account>,建立一个单线程来管理链接，
	//在链接管理中会遇到的情况。
	//客户端正常登陆、退出。
	//ping 超时
	//同一个账号使用多个链接访问。
	//链接处于高延迟状态
	
	
	//建立时间
	//上一次ping时间
	//connection state
	//链接通讯状态  channel state
	//客户端与服务端的时间差值
	
	private Channel channel;
	
	NettyConnection(Channel channel){
		this.channel = channel;
	}
	

	@Override
	public void onAccepted() {
		//连接接入
	}

	@Override
	public void onDisconnected() {
		//连接断开
	}

	@Override
	public void send(IPacket packet) {
		channel.write(packet);
	}

	@Override
	public void recv(IPacket packet) {
		packet.connection(this)	;
		packet.execute();
	}
		
}
