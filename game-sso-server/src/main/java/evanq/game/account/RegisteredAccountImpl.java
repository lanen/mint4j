package evanq.game.account;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class RegisteredAccountImpl extends AbstractRegisteredAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4916023518926712345L;

}
