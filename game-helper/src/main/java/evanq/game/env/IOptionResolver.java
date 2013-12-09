package evanq.game.env;


/**
 * 
 * Option 定位器
 * 
 * 
 * option registry impl a IOptionResolver
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface IOptionResolver {
	
	boolean contains(String key);

	String getOption(String key);

	String getOption(String key, String defaultValue);

	<T> T getOption(String key, Class<T> targetType);

	<T> T getOption(String key, Class<T> targetType, T defaultValue);

}
