package evanq.game.account;

import java.io.Serializable;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractRegisteredAccount implements RegisteredAccount,Serializable,Comparable<RegisteredAccount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8092003561540854036L;
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getFlag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMobile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPasswd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(RegisteredAccount o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
