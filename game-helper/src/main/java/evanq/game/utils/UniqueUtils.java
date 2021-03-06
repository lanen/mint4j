package evanq.game.utils;

import java.util.concurrent.ConcurrentMap;

/**
 * 
 * 检测是否有重命名
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class UniqueUtils {
	
	/**
	 * @param map
	 * @param name
	 */
	public static void assertUnique(ConcurrentMap<String, Boolean> map, String name){
        if (map == null) {
            throw new NullPointerException("map");
        }
        
        if (name == null) {
            throw new NullPointerException("name");
        }
        
        if (map.putIfAbsent(name, Boolean.TRUE) != null) {
            throw new IllegalArgumentException(String.format("'%s' is already in use", name));
        }
	}
}
