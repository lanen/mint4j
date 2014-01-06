package evanq.game.trace;

public interface TraceConstant {

	/**
	 * 跟踪框架
	 */
	public static final String GAME_SYSTEM = "gameSystem";
 
	/**
     * The trace module name for commands.
     */
    public static final String COMMAND = "command";

    /**
     * The trace module name for databases.
     */
    public static final String DATABASE = "database";

    /**
     * The trace module name for locks.
     */
    public static final String LOCK = "lock";

    /**
     * The trace module name for settings.
     */
    public static final String SETTING = "setting";


    /**
     * The trace module name for users.
     */
    public static final String USER = "user";
    
    
    /**
     * The trace module name for netty.
     */
    public static final String CONNECTION = "connection";

}
