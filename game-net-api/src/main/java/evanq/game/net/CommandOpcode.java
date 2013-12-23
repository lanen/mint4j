package evanq.game.net;

import java.util.HashMap;
import java.util.Map;

public class CommandOpcode {

	public static Map<Integer,Class<? >> clazz = new HashMap<Integer,Class<?>>();
	
	static {
		clazz.put(1, O.class);
	}
}
