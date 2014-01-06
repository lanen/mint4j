package evanq.game.trace;


/**
 * The backend of the trace system must implement this interface. Two
 * implementations are supported: the (default) native trace writer
 * implementation that can write to a file and to system out, and an adapter
 * that uses SLF4J (Simple Logging Facade for Java).
 */
interface LogWriter {

    /**
     * Set the name of the database or trace object.
     *
     * @param name the new name
     */
    void setName(String name);

    /**
     * Write a message.
     *
     * @param level the trace level
     * @param module the name of the module
     * @param s the message
     * @param t the exception (may be null)
     */
    void write(int level, String module, String s);
    
    void write(int level,String module, String format, Object... objects);

    /**
     * Check the given trace / log level is enabled.
     *
     * @param level the level
     * @return true if the level is enabled
     */
    boolean isEnabled(int level);

}
