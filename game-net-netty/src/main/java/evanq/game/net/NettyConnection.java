package evanq.game.net;

import io.netty.channel.Channel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;
import evanq.game.trace.TraceConstant;

class NettyConnection extends AbstractNetConnection {

	private static Trace logger = LogSystem.getDefaultTrace(TraceConstant.CONNECTION);
	
	//如何标示链接
	//思路来自linux对socket handle标记方式，每一个链接都作为一个file descriptor
	//map<connecion,INetConnectionHolder>,建立一个单线程来管理链接，
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
	
	//连接号
	//授权验证号
	private Channel channel;	

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	NettyConnection(Channel channel,NetConnectionType type){
		super(type);
		this.channel = channel;		
	}

	@Override
	public void send(IPacket packet) {
		channel.write(packet);
	}

	@Override
	public void recv(IPacket packet) {
		throw new UnsupportedOperationException();
	}
	
	Channel getChannel() {
		return channel;
	}
	

	@Override
	public NetConnectionType type(NetConnectionType newtype) {
		return this.type = newtype;
	}
	
	@Override
	public void connectionTypeChange(NetConnectionType newtype ) {
		NetConnectionType old = type();
		this.type(newtype);
		pcs.firePropertyChange("type", old, newtype);		
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
    
    public String toString(){
    	StringBuffer buf = new StringBuffer();
    	buf.append(channel).append(" ").append(fsm());
    	return buf.toString();
    }
		
    
}
