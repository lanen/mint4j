package evanq.game.database;

import java.util.List;

/**
 * 
 * @author Evan
 *
 */
public abstract class MintDataBase {

	public abstract void execute(String sql);	
	public abstract <T> List<T> execute(String sql,Class<T> clazz);	
	public abstract <T> void save(T object);
	public abstract <T> void update(T object);
	public abstract <T> void delete(T object);
	public abstract <T> T get(Class<T> clazz, String where, Object... args);
	public abstract <T> List<T> list(Class<T> clazz, String where, Object... args);	
	public abstract <T> List<T> list(Class<T> clazz);

}
