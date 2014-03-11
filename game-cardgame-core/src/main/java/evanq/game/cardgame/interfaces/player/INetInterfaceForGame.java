package evanq.game.cardgame.interfaces.player;

/**
 * 
 * 接口层，与服务层之上
 * 
 * 
 * 该层包含与其他系统进行交互的接口与通信设施，在多数应用里
 * 该层可能提供包括Web Services、RMI或Rest等在内的一种或多种通信接口。该层主要由Façade、DTO和Assembler三类组件构成
 * 
 * <p>
 * DTO- DataTransfer Object（数据传输对象） <br/>
 * 也常被称作VO-Value Object(值对象)基于面向对象技术设计的领域对象（即通常所说的“实体”）都是细粒度的，将细粒度的领域对象直接传递到远程调用端需要进行多次网络通信，DTO在设计之初的主要考量是以粗粒度的数据结构减少网络通信并简化调用接口。
 * </p>
 * <li>Reduces network traffic</li>
 * <li>Simplifies remote object and remote interface</li>
 * <li>Transfers more data in fewer remote calls</li>
 * <li>Reduces code duplication</li>
 * <li>Introduces stale transfer objects</li>
 * <li>Increases complexity due to synchronization and version control</li>
 *      
        
        
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface INetInterfaceForGame {

	
	interface DTO{
		
	}
	
	/**
	 * interfaces 层组件
	 * 
	 * 在引入DTO后，DTO与领域对象之间的相互转换工作多由Assembler承担，因此Assembler几乎总是同DTO一起出现。也有一些系统使用反射机制自动实现DTO与领域对象之间的相互转换，Appache的Commons BeanUtils就提供了类似的功能。应该说这两种实现各有利弊，使用Assembler进行对象数据交换更为安全与可控，并且接受编译期检查，但是代码量明显偏多。使用反射机制自动进行象数据交换虽然代码量很少，但却是非常脆弱的，一旦对象属性名发生了变化，数据交互就会失败，并且很难追踪发现。总体来说，Assembler更为直白和稳妥
	 * @author Evan cppmain@gmail.com
	 *
	 */
	interface Assembler{
		
	}
	
	/**
	 * interfaces 层组件
	 * 
	 * <p>
	 * 作为一种设计模式同时也是Interfaces层内的一类组件，Façade的用意在于为远程客户端提供粗粒度的调用接口。Façade本身不处理任何的业务逻辑，它的主要工作就是将一个用户请求委派给一个或多个Service进行处理，同时借助Assembler将Service传入或传出的领域对象转化为DTO进行传输。以下罗列了Façade的多项作用：
	 * </p>
	 * 
	 * <li>Introduces a layer that provides services to remote clients</li>
	 * <li>Exposes a uniform coarse-grained interface</li>
	 * <li>Reduces coupling between the tiers</li>
	 * <li>Promotes layering, increases flexibility and maintainability</li>
	 * <li>Reduces complexity</li>
	 * <li>Improves performance, reduces fine-grained remote methods</li>
	 * <li>Centralizes security management</li>
	 * <li>Centralizes transaction control</li>
	 * <li>Exposes fewer remote interfaces to clients</li>
	 * 
	 * <br/>
	 * 
	 * 实践Façade的过程中最难把握的问题就是Façade的粒度问题。传统的Service均以实体为单位进行组织，而Façade应该具有更粗粒度的组织依据，较为合适的粒度依据有：
	 * 一个高度内聚的模块一个Façade,或者是一个“聚合”(特指领域驱动设计中的聚合)一个Façade.
	 * @author Evan cppmain@gmail.com
	 *
	 */
	interface Facade{
		
	}
}
