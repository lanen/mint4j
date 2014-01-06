package evanq.game.utils;

/**
 * 存放属性
 * @author Evan cppmain@gmail.com
 *
 */
public interface AttributeMap {
	
	<T> Attribute<T> attr(AttributeKey<T> key);
	
}
