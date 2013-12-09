package evanq.game.trace;

/**
 * 
 * 设计Trace 的目的是为了跟踪逻辑模块的日志。
 * @see {@link TraceLevel} 定义跟踪的级别 
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class Trace {

    /**
     * The trace module name for commands.
     */
    public static final String COMMAND = "command";

    /**
     * The trace module name for constraints.
     */
    public static final String CONSTRAINT = "constraint";

    /**
     * The trace module name for databases.
     */
    public static final String DATABASE = "database";

    /**
     * The trace module name for functions.
     */
    public static final String FUNCTION = "function";

    /**
     * The trace module name for file locks.
     */
    public static final String FILE_LOCK = "fileLock";

    /**
     * The trace module name for indexes.
     */
    public static final String INDEX = "index";

    /**
     * The trace module name for the JDBC API.
     */
    public static final String JDBC = "jdbc";

    /**
     * The trace module name for locks.
     */
    public static final String LOCK = "lock";

    /**
     * The trace module name for schemas.
     */
    public static final String SCHEMA = "schema";

    /**
     * The trace module name for sequences.
     */
    public static final String SEQUENCE = "sequence";

    /**
     * The trace module name for settings.
     */
    public static final String SETTING = "setting";

    /**
     * The trace module name for tables.
     */
    public static final String TABLE = "table";

    /**
     * The trace module name for triggers.
     */
    public static final String TRIGGER = "trigger";

    /**
     * The trace module name for users.
     */
    public static final String USER = "user";

    /**
     * The trace module name for the page store.
     */
    public static final String PAGE_STORE = "pageStore";

}
