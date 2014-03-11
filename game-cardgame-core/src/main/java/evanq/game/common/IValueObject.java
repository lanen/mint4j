package evanq.game.common;

import java.io.Serializable;

/**
 * 
 * DTO 对象。一例：用于外部通讯的交互数据。 
 *
 * A value object, as described in the DDD book.
 * 
 */
public interface IValueObject<T> extends Serializable {

  /**
   * Value objects compare by the values of their attributes, they don't have an identity.
   *
   * @param other The other value object.
   * @return <code>true</code> if the given value object's and this value object's attributes are the same.
   */
  boolean sameValueAs(T other);

}
