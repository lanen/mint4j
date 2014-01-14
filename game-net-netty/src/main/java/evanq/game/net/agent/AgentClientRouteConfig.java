package evanq.game.net.agent;


/**
 * 
 * Agent 的连接
 * @author Evan cppmain@gmail.com
 *
 */
public class AgentClientRouteConfig {

	//连接类型
	private byte connectionType;
	
	//连接的需要去请求的地址
	private String remoteHost;
	
	//连接需要去请求的端口
	private int remotePort;
	
	//Inbound or Outbound
	private byte serviceType;
	
	//agent 的 端口
	private int localPort;
	
	public byte getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(byte connectionType) {
		this.connectionType = connectionType;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public int getRemotePort() {
		return remotePort;
	}

	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
	}

	public byte getServiceType() {
		return serviceType;
	}

	public void setServiceType(byte serviceType) {
		this.serviceType = serviceType;
	}

	public int getLocalPort() {
		return localPort;
	}

	public void setLocalPort(int localPort) {
		this.localPort = localPort;
	}

	public static void main(String[] args) {
		
	}
	
	public static void test1(){
		//客户端
		AgentClientRouteConfig config = new AgentClientRouteConfig();
		config.connectionType = 1;
		config.remoteHost="127.0.0.1";
		config.remotePort = 10001;
		config.serviceType = 1;
		config.localPort = 8999;
	}
	
	public static void test2(){
		//客户端
		AgentClientRouteConfig config = new AgentClientRouteConfig();
		config.connectionType = 1;
		config.remoteHost="127.0.0.1";
		config.remotePort = 10001;
		config.serviceType = 1;
		config.localPort = 8999;
	}
	
	public static void test3(){
		//客户端
		AgentClientRouteConfig config = new AgentClientRouteConfig();
		config.connectionType = 1;
		config.remoteHost="127.0.0.1";
		config.remotePort = 10001;
		config.serviceType = 1;
		config.localPort = 8999;
	}
	
}
