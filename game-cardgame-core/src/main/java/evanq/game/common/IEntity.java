package evanq.game.common;

/**
 * 数据持久化的实体
 * 
 * An entity, as explained in the DDD book.
 * 
 * @author Evan cppmain@gmail.com
 * 
 * @param <T>
 */
public interface IEntity<T> {

	/**
	 * Entities compare by identity, not by attributes.
	 * 
	 * @param other
	 *            The other entity.
	 * @return true if the identities are the same, regardles of other
	 *         attributes.
	 */
	boolean sameIdentityAs(T other);

}
