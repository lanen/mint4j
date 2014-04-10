package evanq.game.infrastructure.mint;

import java.util.Map;

/**
 * 
 * 从框架内部取出实例
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface BeanResolver {

	public Object getBean(String name);
	
	public Object getBean(Class<?>	clazz);
	
	public Object getBean(Class<?> clazz, boolean createWhenNotExists);
	
	public Class<?> getType(String beanName);
	/**
	 * 
	 * 获取所有实现某接口的 对象
	 * @param type
	 * @param includeNonSingletons  是否包含非单例
	 * @param allowEagerInit 是否允许饥饿初始化
	 * @return
	 */
	public <T> Map<String, T> beansOfTypeIncludingAncestors(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit);
	
	public <T> String[] getBeanNamesForType(Class<T> type);
	
	/**
	 * 从spring 配置文件中获取alias
	 * @param alias
	 * @return
	 */
	public String[] getAliases(String alias);
	
}
