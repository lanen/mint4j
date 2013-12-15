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



## 参考

