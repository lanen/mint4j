package evanq.game.cardgame.infrastructure.controller;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 * @param <E>
 */
public interface ControllerManager {

	public <E> void add(Class<E> clazz,E instance);
	public <E> E get(Class<E> clazz);
	public <E> void removeController(Class<E> clazz);
	public <E> void removeController(E instance);
	public void atfterStart();
}
