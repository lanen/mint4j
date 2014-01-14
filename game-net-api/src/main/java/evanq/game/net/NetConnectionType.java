package evanq.game.net;


/**
 * 
 * 经过验证之后，连接拥有明确的类型
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public enum NetConnectionType {
	
	/** 空类型 */
	DUMMY((byte)0),
	
	/** 客户端主连接 */
	CLIENT_MASTER((byte)10),
	
	/** 客户端聊天连接 */
	CLIENT_CHAT((byte)11),
	
	/** 客户端场景 */
	CLIENT_SCENE((byte)12),
	
	/**************/
	
	/** 场景服务器连接 */
	NODE_IN_AGENT_SCENE((byte)1),
	
	/** 登陆服务器连接 */
	NODE_IN_AGENT_LOGINSERVER((byte)2),
	
	/** 聊天服务器连接 */
	NODE_IN_AGENT_CHAT((byte)3),
	
	/** NPC 服务器连接 */
	NODE_IN_AGENT_NPC((byte)4);
	
	private byte typeValue;
	
	NetConnectionType(byte typeValue){
		this.typeValue=typeValue;
	}
	
	public byte value(){
		return typeValue;
	}
	
	
	public static NetConnectionType valueOf(int i)  {
		
		for (NetConnectionType theType : NetConnectionType.values()) {
			if(theType.value() == i){
				return theType;
			}
		}
		
		String f = "无法无法获取指定值 %d 的枚举";
		throw new IllegalArgumentException( String.format(f, i) );
	}
}
