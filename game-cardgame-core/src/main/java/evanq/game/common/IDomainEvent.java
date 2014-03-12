package evanq.game.common;

/**
 * 
 * 一个支付行为。（谁，买，多少钱，买时间，记录时间）
 * A domain event is something that is unique, but does not have a lifecycle.
 * The identity may be explicit, for example the sequence number of a payment,
 * or it could be derived from various aspects of the event such as where, when and what
 * has happened.
 * 
 * @author Evan cppmain@gmail.com
 *
 * @param <T>
 */
public interface IDomainEvent<T> {

  /**
   * @param other The other domain event.
   * @return <code>true</code> if the given domain event and this event are regarded as being the same event.
   */
  boolean sameEventAs(T other);

}
