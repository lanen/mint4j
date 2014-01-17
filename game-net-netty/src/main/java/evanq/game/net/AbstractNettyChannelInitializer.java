package evanq.game.net;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

import java.beans.PropertyChangeListener;

public abstract class AbstractNettyChannelInitializer  extends ChannelInitializer<SocketChannel> implements PropertyChangeListener{


	/**
	 * 作为客户端，通过connectionType 来开启编解码器
	 * 
	 * @param connectionType
	 * @param ch
	 * @throws Exception
	 */
	protected abstract void enableChannel(NetConnectionType connectionType,Channel ch) throws Exception;
	
	
	static final AttributeKey<NettyConnection> NETCONNECTION_ATTR = AttributeKey.valueOf("NetConnection");
	static final AttributeKey<NetConnectionType> NETCONNECTION_TYPE_ATTR = AttributeKey.valueOf("NetConnectionType");
	
	
	public static NettyConnection get(Channel channel){
		Attribute<NettyConnection> attr = channel.attr(NETCONNECTION_ATTR);
		return attr.get();
	}
	
	public static void set(Channel channel,NettyConnection nc){
		Attribute<NettyConnection> attr = channel.attr(NETCONNECTION_ATTR);
		attr.set(nc);
	}
	
	public static void setChannelType(Channel channel,NetConnectionType type){
		Attribute<NetConnectionType> attr = channel.attr(NETCONNECTION_TYPE_ATTR);
		attr.set(type);		
	}
	
	
	public static NetConnectionType getChannelType(Channel channel){
		Attribute<NetConnectionType> attr = channel.attr(NETCONNECTION_TYPE_ATTR);
		return attr.get();
	}
	
	public static NetConnectionType getChannelType(INetConnection connection){
		NettyConnection nc = (NettyConnection)connection;
		return getChannelType(nc.getChannel());
	}

}
