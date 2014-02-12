package evanq.game.cas.web;

import evanq.game.account.Account;

public class CasLoginAccount implements Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = -969939762917513247L;

	private long id;
	
	private String account;
	
	public CasLoginAccount(long id	) {
		this.id = id;
	}
	
	public CasLoginAccount(String account) {
		this.account = account;
	}
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getAccount() {
		return account;
	}

	@Override
	public boolean matches(Account account) {
		return false;
	}

}
