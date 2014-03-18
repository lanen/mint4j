package evanq.game.cardgame.infrastructure.services;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 * @param <E>
 */
public interface ServiceManager {

	public <E> void add(Class<E> clazz,E instance);
	public <E> E get(Class<E> clazz);
	public <E> void removeController(Class<E> clazz);
	public <E> void removeController(E instance);
	public void atfterStart();
}
