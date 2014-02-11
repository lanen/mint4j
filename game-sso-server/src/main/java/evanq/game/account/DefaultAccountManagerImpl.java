package evanq.game.account;

import javax.validation.constraints.NotNull;

public class DefaultAccountManagerImpl implements AccountManager {
	
	@NotNull
	private AccountManagerDao accountManagerDao;
	
	@Override
	public RegisteredAccount save(RegisteredAccount registeredAccount) {
		
		
		return null;
	}

	@Override
	public RegisteredAccount delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisteredAccount findAccountBy(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisteredAccount findAccountBy(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matchesExistingAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	public AccountManagerDao getAccountManagerDao() {
		return accountManagerDao;
	}

	public void setAccountManagerDao(AccountManagerDao accountManagerDao) {
		this.accountManagerDao = accountManagerDao;
	}

}
