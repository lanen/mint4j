package evanq.game.infrastructure.mint.commandexecutors;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.infrastructure.WorldUtils;
import evanq.game.infrastructure.mint.commandexecutors.method.ExecutorMethod;
import evanq.game.utils.AnnotationUtils;
import evanq.game.utils.ClassUtils;
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
	
	private Object defaultExecutor;
	
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
	public void setDefaultExecutor(Object defaultExecutor) {
		this.defaultExecutor = defaultExecutor;
	}

	/**
	 * Return the default handler for this handler mapping,
	 * or <code>null</code> if none.
	 */
	public Object getDefaultExecutor() {
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
	 * @param opcode
	 * @return
	 * @throws Exception
	 */
	public final CommandExecutorChain getExecutor(int opcode) throws Exception {
		
		Object executor = getExecutorInternal(opcode);
		
		if (executor == null) {
			executor = getDefaultExecutor();
		}
		
		if (executor == null) {
			return null;
		}
		
		return null;
		
	}
	
	/**
	 * 
	 * @param opcode
	 * @return
	 */
	protected abstract Object getExecutorInternal (int opcode);
	
	
	/**
	 * 确认目标是否是处理器
	 * 
	 * @param beanType
	 * @return
	 */
	protected abstract boolean isExecutor(Class<?> beanType);

	/**
	 * Invoked after all handler methods have been detected.
	 * @param handlerMethods a read-only map with handler methods and mappings.
	 */
	protected void commandMethodsInitialized(Map<T, ExecutorMethod> executorMethods) {
	}

	/**
	 * 
	 * 初始化方法执行器
	 * 
	 */
	protected void initExecutorMethods(){
		
		//TODO 在整个程序的上下文中查找
				
		String[] beanNames = WorldUtils.beanResolver().getBeanNamesForType(Object.class);
		System.out.println("beanNames");
		
		for (String beanName : beanNames) {
			System.out.println(beanName);
//			if (isExecutor(WorldUtils.beanResolver().getType(beanName))){
//				detectExecutorMethods( WorldUtils.beanResolver().getBean(beanName));
//			}
		}
		
		commandMethodsInitialized(getExecutorMethods());		
	}
	
	/**
	 * 
	 * 从给定对象中查找方法
	 * @param handler
	 */
	protected void detectExecutorMethods(final Object handler){
		
		System.out.println("detectExecutorMethods：" +handler);
	}
	
	
	/**
	 * 
	 * 注册执行器方法
	 * 
	 * @param handler
	 * @param method
	 * @param mapping
	 */
	protected void registerExecutorMethod(Object handler, Method method, T mapping){
		
		//TODO 通过 handler 和 method 生成 ExecutorMethod
		ExecutorMethod newExecutorMethod = new ExecutorMethod(handler,method);
		
		//TODO 获取已有的的ExecutorMethod 做替换的步骤
		ExecutorMethod oldExecutorMethod = executorMethods.get(mapping);
		
		if(null != oldExecutorMethod && ! oldExecutorMethod.equals(newExecutorMethod))  {
			//TODO 发送竞争处理器的情况
			
		}
		
		executorMethods.put(mapping, newExecutorMethod);
		
		if(logger.isInfoEnabled()){
			logger.info("Mapping {} ", mapping);
		}
		
	}
	

}
