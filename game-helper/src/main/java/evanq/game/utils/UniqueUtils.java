package evanq.game.utils;

import java.util.concurrent.ConcurrentMap;

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
