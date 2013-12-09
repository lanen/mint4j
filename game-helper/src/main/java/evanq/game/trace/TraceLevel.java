package evanq.game.trace;

/**
 * 
 * 定义日志跟踪的级别
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class TraceLevel {

	/**
     * The parent trace level should be used.
     */
    public static final int PARENT = -1;

    /**
     * This trace level means nothing should be written.
     */
    public static final int OFF = 0;

    /**
     * This trace level means only errors should be written.
     */
    public static final int ERROR = 1;

    /**
     * This trace level means errors and informational messages should be
     * written.
     */
    public static final int INFO = 2;

    /**
     * This trace level means all type of messages should be written.
     */
    public static final int DEBUG = 3;

    /**
     * This trace level means all type of messages should be written, but
     * instead of using the trace file the messages should be written to SLF4J.
     * 
     * 重定向到slf4j 实现
     */
    public static final int ADAPTER = 4;

    /**
     * The default level for system out trace messages.
     */
    public static final int DEFAULT_TRACE_LEVEL_SYSTEM_OUT = OFF;

    /**
     * The default level for file trace messages.
     */
    public static final int DEFAULT_TRACE_LEVEL_FILE = ERROR;


}
