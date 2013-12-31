package evanq.game.net;

class NettyConnectionGroup extends AbstractNetConnectionGroup {

	 NettyConnectionGroup(int maxConnectionSize,
			INetConnectionFactory factory, INetManager netManager) {
		super(maxConnectionSize, factory, netManager);
	}

	
	
}
