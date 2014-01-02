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
	DUMMY,
	
	/** 客户端主连接 */
	CLIENT_MASTER,
	
	/** 客户端聊天连接 */
	CLIENT_CHAT,
	
	/** 客户端场景 */
	CLIENT_SCENE,
	
	/**************/
	
	/** 场景服务器连接 */
	NODE_IN_AGENT_SCENE,
	
	/** 登陆服务器连接 */
	NODE_IN_AGENT_LOGINSERVER,
	
	/** 聊天服务器连接 */
	NODE_IN_AGENT_CHAT,
	
	/** NPC 服务器连接 */
	NODE_IN_AGENT_NPC
	
}
