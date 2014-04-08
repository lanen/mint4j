package evanq.game.utils;


/**
 * Interface that can be implemented by objects that should be
 * orderable, for example in a Collection.
 *
 * <p>The actual order can be interpreted as prioritization, with
 * the first object (with the lowest order value) having the highest
 * priority.
 *
 * <p>Note that there is a 'priority' marker for this interface:
 * {@link PriorityOrdered}. Order values expressed by PriorityOrdered
 * objects always apply before order values of 'plain' Ordered values.
 *
 * @author Juergen Hoeller
 * @since 07.04.2003
 * @see OrderComparator
 * @see org.springframework.core.annotation.Order
 */
public interface Ordered {

	/**
	 * Useful constant for the highest precedence value.
	 * @see java.lang.Integer#MIN_VALUE
	 */
	int HIGHEST_PRECEDENCE = Integer.MIN_VALUE;

	/**
	 * Useful constant for the lowest precedence value.
	 * @see java.lang.Integer#MAX_VALUE
	 */
	int LOWEST_PRECEDENCE = Integer.MAX_VALUE;


	/**
	 * Return the order value of this object, with a
	 * higher value meaning greater in terms of sorting.
	 * <p>Normally starting with 0, with <code>Integer.MAX_VALUE</code>
	 * indicating the greatest value. Same order values will result
	 * in arbitrary positions for the affected objects.
	 * <p>Higher values can be interpreted as lower priority. As a
	 * consequence, the object with the lowest value has highest priority
	 * (somewhat analogous to Servlet "load-on-startup" values).
	 * @return the order value
	 */
	int getOrder();

}
