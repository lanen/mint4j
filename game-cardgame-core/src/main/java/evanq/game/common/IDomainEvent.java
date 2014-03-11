package evanq.game.common;

/**
 *  
 * DomainEvent 可以理解成：订单序列号。本身没有状态，可以在多分层传递。
 * 
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
