package evanq.game.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * 建立数据的快捷方式
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class New {
	
	  /**
     * Create a new ArrayList.
     *
     * @param <T> the type
     * @return the object
     */
    public static <T> ArrayList<T> arrayList() {
        return new ArrayList<T>(4);
    }

    /**
     * Create a new HashMap.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @return the object
     */
    public static <K, V> HashMap<K, V> hashMap() {
        return new HashMap<K, V>();
    }

    /**
     * Create a new HashMap.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param initialCapacity the initial capacity
     * @return the object
     */
    public static <K, V> HashMap<K, V> hashMap(int initialCapacity) {
        return new HashMap<K, V>(initialCapacity);
    }

    /**
     * Create a new HashSet.
     *
     * @param <T> the type
     * @return the object
     */
    public static <T> HashSet<T> hashSet() {
        return new HashSet<T>();
    }

    /**
     * Create a new ArrayList.
     *
     * @param <T> the type
     * @param c the collection
     * @return the object
     */
    public static <T> ArrayList<T> arrayList(Collection<T> c) {
    	return new ArrayList<T>(c);
    }
    
    public static <T> List<T> list(T... arr) {
        return Arrays.asList(arr);
    }

    /**
     * Create a new ArrayList.
     *
     * @param <T> the type
     * @param initialCapacity the initial capacity
     * @return the object
     */
    public static <T> ArrayList<T> arrayList(int initialCapacity) {
    	return new ArrayList<T>(initialCapacity);
    }
    
    
    /**
     * 创建一个注册表
     * 
     * @return a registry
     */
    public static <K,V> Registry<K, V>  registry() {
        return new Registry<K,V>();
    }
    
    
    /**
     * Creates a new fastest {@link ConcurrentMap} implementaion for the current platform.
     */
    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap() {
    	return new ConcurrentHashMap<K, V>();
    }
    
    /**
     * Creates a new fastest {@link LinkedBlockingQueue} implementaion for the current platform.
     */
    public static <V> LinkedBlockingQueue<V> newLinkedQueue() {
    	return new LinkedBlockingQueue<V>();
    }

}
