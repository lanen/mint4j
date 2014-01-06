package evanq.game.env.impl;

import evanq.game.trace.LogLevel;
import evanq.game.utils.AttributeKey;
import evanq.game.utils.DefaultAttributeMap;
import evanq.game.utils.SystemPropertyUtil;

/**
 * 
 * @see <a href="http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html" >System Properties</a>
 * 
 * @author Evan
 *
 */
public class SystemPropertyOptions extends DefaultAttributeMap {

	//设置日志，
	//日志级别
	//日志位置
	//SLF4J日志配置
	public static final AttributeKey<Integer> LOG_LEVEL = AttributeKey.valueOf("logLevel");
	public static final AttributeKey<String>  LOG_PATH = AttributeKey.valueOf("logPath");
	public static final AttributeKey<Boolean> USE_SLF4J = AttributeKey.valueOf("useSLF4J");
	
	//System.getProperty(key)
	//VM 级别的系统参数
	public SystemPropertyOptions() {
		
		attr(LOG_LEVEL).set(SystemPropertyUtil.getInt(LOG_LEVEL.toString(), LogLevel.INFO));
		attr(LOG_PATH).set(SystemPropertyUtil.get(LOG_PATH.toString()));
		attr(USE_SLF4J).set(SystemPropertyUtil.getBoolean(USE_SLF4J.toString(),false));
		
	}
}
