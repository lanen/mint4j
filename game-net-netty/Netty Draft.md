Netty 应用
==========

## Netty 用于游戏开发须知
### 依赖类库

`JCraft` - [JCraft 官网](http://www.jcraft.com/jzlib/) 是zlib 的java实现版本，用于压缩数据包

	<dependency>
		<groupId>com.jcraft</groupId>
		<artifactId>jzlib</artifactId>
		<version>1.1.3</version>
	</dependency>


            

### Netty API 设计原理

`Channel`

基于`Channel`的IO操作都是非阻塞的。


`ChannelConfig` 是`ChannelOption<T>`

`ChannelOption<T>` 是一个配置项类型和名称的包装器，继承`UniqueName`保证每一个名称必须唯一。

`EventLoop`

`ChannelFuture`

`ChannelPipeline`





### 对Netty的抽象与适配

### Netty 常见问题

### Netty 调优


## 服务器连接管理方案

### 用例描述

- 服务器组之间的连接
- 接受连接
- 连接握手
- 连接心跳
- 连接断开、重连
- 连接读写
- 连接诊断与统计


### 方案设计

1. 服务器组节点

	服务器之间拥有不同的职责，agent（gateway）服务器负责持有来自客户端的连接和来自业务节点的连接，agent会将客户端请求转发到业务节点中。agent必须开放两种端口，`面向客户端`的对外端口和`面向业务节点`的转发端口。
	
	

2. 接受连接

	新生的连接需要经过验证，才能被用于业务处理。连接是区分职责的，经由服务器验证，会将连接归类到相同职责的`ConnectionHolder`中（实现或持有`ConnectionHolder`的对象都有网络IO能力）。
	
3. 

### 实现要点


- 连接不论类型，放在同一个容器中；
- 连接拥有`组`管理能力


	public interface INetCommand {

		/**
		 * 
		 * Return the connection of this command.
		 * 
		 * @return {@link INetConnection}
		 */
		INetConnection connection();
		
		/**
		 * 设置当前的连接
		 * @param nc
		 * @return
		 */
		INetConnection connection(INetConnection nc);
		
		/**
		 * 
		 */
		public void execute();
		
	}

	public interface IPacket extends INetCommand {

	
	}

	public interface INetConnect{

		public void onAccepted();
		
		public void onDisconnected();
		
		public void send(IPacket packet);
		
		public void recv(IPacket packet);

	}

	//让连接拥有组的管理能力
	public interface INetConnectionGroup {

	
	}

	//心跳机制


## 参考


## eclipse 插件


[Eclipse SQL Explorer](http://eclipsesql.sourceforge.net/)


[Eclipse十六进制编辑器插件](http://ehep.sourceforge.net/)

[ a Java framework for building modern web applications](https://vaadin.com/home)


Lockness 用于分析Java 线程堆


[Log4e](http://log4e.jayefem.de/ "Log4e")


AmaterasUML


[Memory Analyzer (MAT)](http://www.eclipse.org/mat/ "Memory Analyzer (MAT)")



[moreclipboard](http://moreclipboard.sourceforge.net/)



[Apache Directory Server](http://directory.apache.org/)



Skia 图形引擎

http://javaposse.com/


[基于 OAuth 安全协议的 Java 应用编程](http://www.ibm.com/developerworks/cn/java/j-lo-oauth/)

OAuth Solution解决账号和连接授权问题，在开发阶段，客户端直接请求agent服务器，服务器等待握手请求，否则在连接timeout.握手请求包含access_token（编码了账号id,过期时间）
