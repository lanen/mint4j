package evanq.game.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 注册表
 * 
 * @author Evan cppmain@gmail.com
 * 
 * @param <K>
 *            the key
 * @param <V>
 *            the class will be store
 */
public class Registry<K, V> {

	@SuppressWarnings("rawtypes")
	private static final InheritableThreadLocal<Registry> inheritableThreadLocal = new InheritableThreadLocal<Registry>();

	private Map<K, V> registryMap = new HashMap<K, V>();

	public void put(K k, V v) {
		registryMap.put(k, v);
	}

	public V get(K k) {
		return registryMap.get(k);
	}

	public void clear() {
		registryMap.clear();
	}
	
	public static <K, V> Registry<K, V> getThreadContextInstance() {
		Registry<K, V> pr = (Registry<K, V>)inheritableThreadLocal.get();
		if (pr == null) {
			pr = new Registry<K, V>();
			inheritableThreadLocal.set(pr);
		}
		return pr;
	}

}
