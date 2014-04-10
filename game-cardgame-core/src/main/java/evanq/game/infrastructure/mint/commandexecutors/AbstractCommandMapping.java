package evanq.game.infrastructure.mint.commandexecutors;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.infrastructure.WorldUtils;
import evanq.game.infrastructure.mint.commandexecutors.method.ExecutorMethod;
import evanq.game.utils.Ordered;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 * @param <T> 作为执行器描述信息
 */
public abstract class AbstractCommandMapping<T> implements CommandMapping, Ordered {
	
	private Logger logger = LoggerFactory.getLogger(CommandMapping.class);
	
	private int order = Integer.MAX_VALUE;  // default: same as non-Ordered

	private final Map<T, ExecutorMethod> executorMethods = new LinkedHashMap<T, ExecutorMethod>();
	
	private final Map<ExecutorMethod,CommandExecutionChain> chainMappings = new LinkedHashMap<ExecutorMethod,CommandExecutionChain>();
	
	/**
	 * 从配置中获取执行器包的 别名
	 */
	private static final String EXECUTOR_METHOD_BASE_PACKAGE = "CommandExecutorPackage";
	
	
	private ExecutorMethod defaultExecutor;
	
	public AbstractCommandMapping(){
		
		initExecutorMethods();
	}
	
	/**
	 * Specify the order value for this HandlerMapping bean.
	 * <p>Default value is <code>Integer.MAX_VALUE</code>, meaning that it's non-ordered.
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	public final void setOrder(int order) {
	  this.order = order;
	}

	public final int getOrder() {
	  return this.order;
	}
	
	/**
	 * <p>Default is <code>null</code>, indicating no default handler.
	 */
	public void setDefaultExecutor(ExecutorMethod defaultExecutor) {
		this.defaultExecutor = defaultExecutor;
	}
	
	/**
	 * Return the default handler for this handler mapping,
	 * or <code>null</code> if none.
	 */
	public ExecutorMethod getDefaultExecutor() {
		return this.defaultExecutor;
	}
	/**
	 * Return a map with all handler methods and their mappings.
	 */
	public Map<T, ExecutorMethod> getExecutorMethods() {
		return Collections.unmodifiableMap(executorMethods);
	}
	
	/**
	 * Look up a handler for the given request, falling back to the default
	 * handler if no specific one is found.
	 * 
	 * @param command
	 * @return
	 * @throws Exception
	 */
	
	public final CommandExecutionChain getExecutor(Object command) throws Exception {
		
		ExecutorMethod executor = getExecutorInternal(command);

		if (executor == null) {
			executor =  getDefaultExecutor();
		}
		
		if(null == executor)return null;
		
		return chainMappings.get(executor);
		
	}
	

	/**
	 * 
	 * 让子类决定 命令（数据包）的类型
	 * 
	 * @param command
	 * @return
	 */
	protected abstract ExecutorMethod getExecutorInternal (Object command);
	
	/**	
	 * 确认目标是否是处理器
	 * 
	 * @param beanType
	 * @return
	 */
	protected abstract boolean isExecutor(Class<?> beanType);


	protected ExecutorMethod getExecutorMethod(T t){
		return executorMethods.get(t);
	}
	
	
	/**
	 * Invoked after all handler methods have been detected.
	 * @param handlerMethods a read-only map with handler methods and mappings.
	 */
	protected void commandMethodsInitialized(Map<T, ExecutorMethod> executorMethods) {
		
		if(executorMethods.isEmpty()){
			
			logger.warn("没有 ExecutorMethod 的映射");
		}
		
	}

	/**
	 * 
	 * 初始化方法执行器
	 * 
	 */
	protected void initExecutorMethods(){
		
		//TODO 在整个程序的上下文中查找
		String[] aliases = WorldUtils.beanResolver().getAliases(EXECUTOR_METHOD_BASE_PACKAGE);
		for (int i = 0; i < aliases.length; i++) {
			
			Set<ExecutorMethod> findExecutorMethods = WorldUtils.commandExecutorResolver().findExecutorMethod(aliases[i]);
			
			for (ExecutorMethod exeMethod : findExecutorMethods) {
				
				T executorMethodInfo = getExecutorMethodInfo(exeMethod);
				registerExecutorMethod(exeMethod, executorMethodInfo);
			}			
		}
		
		//TODO 完成所有初始化
		commandMethodsInitialized(getExecutorMethods());		
	}
	
	protected abstract T getExecutorMethodInfo(ExecutorMethod exeMethod);
	/**
	 * 
	 * 注册执行器方法
	 * 
	 * @param handler
	 * @param method
	 * @param mapping
	 */
	protected void registerExecutorMethod(ExecutorMethod newExecutorMethod, T mapping){
		
		
		//TODO 获取已有的的ExecutorMethod 做替换的步骤
		ExecutorMethod oldExecutorMethod = executorMethods.get(mapping);
		
		if(null != oldExecutorMethod && ! oldExecutorMethod.equals(newExecutorMethod))  {
			//TODO 发送竞争处理器的情况
			logger.warn("发送竞争处理器的情况");
		}
		
		executorMethods.put(mapping, newExecutorMethod);
		chainMappings.put(newExecutorMethod, new CommandExecutionChain(newExecutorMethod));
		
		if(logger.isInfoEnabled()){
			logger.info("Mapping {} ", mapping);
		}
	}
	

}
