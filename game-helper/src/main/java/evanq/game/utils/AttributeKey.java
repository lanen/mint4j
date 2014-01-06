package evanq.game.utils;

import java.util.concurrent.ConcurrentMap;

import evanq.game.helper.New;

/**
 * 
 * @param <T>   the type of the {@link Attribute} which can be accessed via this {@link AttributeKey}.
 */
public final class AttributeKey<T>  {

    private static final ConcurrentMap<String, Boolean> names = New.newConcurrentHashMap();

    /**
     * Creates a new {@link AttributeKey} with the specified {@code name}.
     */
    public static <T> AttributeKey<T> valueOf(String name) {
        return new AttributeKey<T>(name);
    }

	private String name;
	
	private AttributeKey(String _name){
		
		UniqueUtils.assertUnique(names, _name);
		
		this.name = _name;
	}
	  @Override
    public String toString() {
        return name;
    }
	    
}
