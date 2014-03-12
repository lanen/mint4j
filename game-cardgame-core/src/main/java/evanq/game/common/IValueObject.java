package evanq.game.common;

import java.io.Serializable;

/**
 *
 *	
 *
 *<p>
 * In P of EAA I described Value Object as a small object such as a Money or date range object. 
 * Their key property is that they follow value semantics rather than reference semantics.
 *</p>
 *
 *<p>
 * Examples of value objects are things like numbers, dates, monies and strings. Usually, they are small objects which are used quite widely
 *</p>
 * A value object, as described in the DDD book.
 * 
 */
public interface IValueObject<T> extends Serializable {

  /**
   * 
   * 两个值对象比较，当所有成员变量都相等则 equal() 相等
   * Value objects compare by the values of their attributes, they don't have an identity.
   *
   * @param other The other value object.
   * @return <code>true</code> if the given value object's and this value object's attributes are the same.
   */
  boolean sameValueAs(T other);

}
