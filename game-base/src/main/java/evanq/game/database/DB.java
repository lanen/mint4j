package evanq.game.database;

import evanq.game.database.impl.HibernateMintDatabase;
import evanq.game.env.IEnvironment;

/**
 * 
 * 集装了数据库实现
 * 
 * @author Evan
 *
 */
public class DB {

	private static class Singleton {
		public static DB INSTANCE = new DB();
	}

	public static DB getInstance() {
		return Singleton.INSTANCE;
	}

	private DB() {
	}
	
	/** 分区 */
	private MintDataBase realm;
	
	/** 游戏 */
	private MintDataBase game;
	
	/** 角色 */
	private MintDataBase role;
	
	public void setupDB(IEnvironment env){
		
		realm = new HibernateMintDatabase("./mint/etc/realmd.cfg.xml");
	}

	public static MintDataBase realm(){
		return Singleton.INSTANCE.realm;
	}
	
	public static MintDataBase game(){
		return Singleton.INSTANCE.game;
	}
	
	public static MintDataBase role(){
		return Singleton.INSTANCE.role;
	}
	
}
