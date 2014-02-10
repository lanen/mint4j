package evanq.game.account;

import java.io.Serializable;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public interface RegisteredAccount extends Cloneable, Serializable {

	public long getId();
	public boolean isEnabled();
	public int getFlag();
	public String getAccount();
	public String getEmail();
	public String getMobile();
	public String getPasswd();
	
}
