package evanq.game.cardgame.domain.model.role;

import evanq.game.common.IValueObject;

/**
 * 
 * 角色编号
 * 
 * @author Evan cppmain@gmail.com
 * 
 */
public final class RoleId implements IValueObject<RoleId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3651535326895093973L;

	private int id;

	public RoleId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		//TODO RoleId toString
		return "" + id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RoleId other = (RoleId) o;

		return sameValueAs(other);
	}

	@Override
	public boolean sameValueAs(RoleId other) {
		return other != null && this.id == other.id;
	}

}
