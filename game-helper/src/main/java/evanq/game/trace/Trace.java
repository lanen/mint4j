package evanq.game.trace;


public class Trace {
	
    private final LogWriter traceWriter;
    private final String module;
    private int traceLevel = LogLevel.PARENT;

    Trace(LogWriter traceWriter, String module) {
        this.traceWriter = traceWriter;
        this.module = module;
    }

    /**
     * Set the trace level of this component. This setting overrides the parent
     * trace level.
     *
     * @param level the new level
     */
    public void setLevel(int level) {
        this.traceLevel = level;
    }

    private boolean isEnabled(int level) {
        if (this.traceLevel == LogLevel.PARENT) {
            return traceWriter.isEnabled(level);
        }
        return level <= this.traceLevel;
    }

    /**
     * Check if the trace level is equal or higher than INFO.
     *
     * @return true if it is
     */
    public boolean isInfoEnabled() {
        return isEnabled(LogLevel.INFO);
    }

    /**
     * Check if the trace level is equal or higher than DEBUG.
     *
     * @return true if it is
     */
    public boolean isDebugEnabled() {
    	return isEnabled(LogLevel.DEBUG);
    }
    /**
     * Check if the trace level is equal or higher than DEBUG.
     *
     * @return true if it is
     */
    public boolean isWarnEnabled() {
        return isEnabled(LogLevel.WARN);
    }


    /**
     * Write a message with trace level ERROR to the trace system.
     *
     * @param t the exception
     * @param s the message
     * @param params the parameters
     */
    public void error( String s, Object... params) {
    	if (isEnabled(LogLevel.ERROR)) {
    		traceWriter.write(LogLevel.ERROR, module, s, params);
    	}
    } 
    public void error( String s){
    	if (isEnabled(LogLevel.ERROR)) {
    		traceWriter.write(LogLevel.ERROR, module, s);
    	}
    }
    public void warn( String s, Object... params) {
        if (isEnabled(LogLevel.WARN)) {
            traceWriter.write(LogLevel.WARN, module, s, params);
        }
    } 
    public void warn( String s){
    	if (isEnabled(LogLevel.ERROR)) {
    		traceWriter.write(LogLevel.WARN, module, s);
    	}
    }

    /**
     * Write a message with trace level INFO to the trace system.
     *
     * @param s the message
     */
    public void info(String s) {
        if (isEnabled(LogLevel.INFO)) {
            traceWriter.write(LogLevel.INFO, module, s);
        }
    }

    /**
     * Write a message with trace level INFO to the trace system.
     *
     * @param s the message
     * @param params the parameters
     */
    public void info(String s, Object... params) {
        if (isEnabled(LogLevel.INFO)) {
            traceWriter.write(LogLevel.INFO, module, s, params);
        }
    }

    
    /**
     * Write a message with trace level DEBUG to the trace system.
     *
     * @param s the message
     * @param params the parameters
     */
    public void debug(String s, Object... params) {
        if (isEnabled(LogLevel.DEBUG)) {
            traceWriter.write(LogLevel.DEBUG, module, s, params);
        }
    }

    /**
     * Write a message with trace level DEBUG to the trace system.
     *
     * @param s the message
     */
    public void debug(String s) {
        if (isEnabled(LogLevel.DEBUG)) {
            traceWriter.write(LogLevel.DEBUG, module, s);
        }
    }


}
