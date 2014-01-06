package evanq.game.utils;

import evanq.game.trace.LogLevel;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;
import evanq.game.trace.TraceConstant;

/**
 * 
 * 异常工具
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ExceptionUtils {

	private static LogSystem exceptionLogger ;
	private static Trace trace;
	static{
		if(null == exceptionLogger){
			//TODO 获取特殊的日志记录地址
			
			exceptionLogger = new LogSystem(TraceConstant.EXCEPTION);
			exceptionLogger.setLogLevel(LogLevel.INFO);
			trace = exceptionLogger.getTrace(TraceConstant.EXCEPTION);
		}
		
	}
	public static void printStackTrace(Throwable t) {
		trace.info("{}",t);
	}
	
	public static void logException(String format, Object... objects ){
		trace.info(format,objects);
	}
	public static Trace getTrace(){
		return trace;
	}
	public static void throwException(Throwable t) {
//		if (hasUnsafe()) {
//			PlatformDependent0.throwException(t);
//		} else {
//		}
		ExceptionUtils.<RuntimeException> throwException0(t);
	}

	@SuppressWarnings("unchecked")
	private static <E extends Throwable> void throwException0(Throwable t)
			throws E {
		throw (E) t;
	}

}
