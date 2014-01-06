package evanq.game.trace;

public interface LogLevel {
    /**
     * The parent log level should be used.
     */
    public static final int PARENT = -1;

    /**
     * This log level means nothing should be written.
     */
    public static final int OFF = 0;

    /**
     * This log level means only errors should be written.
     */
    public static final int ERROR = 1;
    
    public static final int WARN = 2;

    /**
     * This log level means errors and informational messages should be
     * written.
     */
    public static final int INFO = 3;

    /**
     * This log level means all type of messages should be written.
     */
    public static final int DEBUG = 4;


}
