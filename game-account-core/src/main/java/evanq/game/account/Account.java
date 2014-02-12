package evanq.game.account;

import java.io.Serializable;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface Account extends Serializable {

	public long getId();
	
	public String getAccount();
	
	public boolean matches(Account account);
}
