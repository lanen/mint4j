package evanq.game.account.web.form;

import evanq.game.account.Account;

/**
 * 
 * hold the register request form data
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RegisterAccountForm implements Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5203579840805100208L;

	private long id;
	
	private String account;
	
	private String password;
	
	private String passwordConfirmed;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmed() {
		return passwordConfirmed;
	}
	public void setPasswordConfirmed(String passwordConfirmed) {
		this.passwordConfirmed = passwordConfirmed;
	}
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public boolean matches(Account account) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}