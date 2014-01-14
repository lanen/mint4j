package evanq.game.net;

/**
 * 数据包类型
 * 
 * @author Evan
 *
 */
public final class PacketConst {

	public static final char PACKET_TYPE_CLIENT = 'C';
	public static final char PACKET_TYPE_SERVER = 'S';
	
	//char == unsigned short
	
	//参考链接管理的流程图
	public static final char C_CONNECT_REQUEST    = 1;
	public static final char S_CONNECT_REQUEST_OK = 2;
	public static final char C_HEART_BEAT = 3;
	
	
	
}
