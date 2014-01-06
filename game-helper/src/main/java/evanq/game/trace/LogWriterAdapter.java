package evanq.game.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This adapter sends log output to SLF4J. SLF4J supports multiple
 * implementations such as Logback, Log4j, Jakarta Commons Logging (JCL), JDK
 * 1.4 logging, x4juli, and Simple Log. To use SLF4J, you need to add the
 * required jar files to the classpath, and set the trace level to 4 when opening
 * a database:
 *
 * <pre>
 * jdbc:h2:&tilde;/test;TRACE_LEVEL_FILE=4
 * </pre>
 *
 */
class LogWriterAdapter implements LogWriter {

    private final Logger logger;

    LogWriterAdapter(String loggerName){
    	logger= LoggerFactory.getLogger(loggerName);    	
    }
    
    LogWriterAdapter(Class<?> clazz){
    	logger= LoggerFactory.getLogger(clazz);    	
    }
    
    @Override
    public void setName(String name) {
      
    }

    @Override
    public boolean isEnabled(int level) {
        switch (level) {
        case LogLevel.DEBUG:
            return logger.isDebugEnabled();
        case LogLevel.INFO:
            return logger.isInfoEnabled();
        case LogLevel.ERROR:
        	return logger.isErrorEnabled();
        case LogLevel.WARN:
            return logger.isWarnEnabled();
        default:
            return false;
        }
    }
    
    
    @Override
	public void write(int level,String module, String format, Object... objects) {
    	
    	if (isEnabled(level)) { 
    		switch (level) {
    		case LogLevel.DEBUG:
    			logger.debug(format,objects);
    			break;
    		case LogLevel.INFO:
    			logger.info(format,objects);
    			break;
    		case LogLevel.WARN:
    			logger.warn(format,objects);
    			break;
    		case LogLevel.ERROR:
    			logger.error(format,objects);
    			break;
    		default:
    		}
    	}
	}

	@Override
    public void write(int level, String module, String s) {
        if (isEnabled(level)) { 
			switch (level) {
			case LogLevel.DEBUG:
				logger.debug(s);
				break;
			case LogLevel.INFO:
				logger.info(s);
				break;
			case LogLevel.WARN:
				logger.warn(s);
				break;
			case LogLevel.ERROR:
				logger.error(s);
				break;
			default:
			}
           
        }
    }

}
