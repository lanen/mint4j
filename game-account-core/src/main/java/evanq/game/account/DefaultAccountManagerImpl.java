package evanq.game.account;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class DefaultAccountManagerImpl implements AccountManager {
	
	@NotNull
	private AccountManagerDao accountManagerDao;
	
	@Override
	public RegisteredAccount save(RegisteredAccount registeredAccount) {
		RegisteredAccount save = accountManagerDao.save(registeredAccount);
		
		return save;
	}

	@Override
	public RegisteredAccount delete(long id) {
		RegisteredAccount findAccountBy = accountManagerDao.findAccountBy(id);
		accountManagerDao.delete(findAccountBy);
		return findAccountBy;
	}

	@Override
	public RegisteredAccount findAccountBy(long id) {
		RegisteredAccount findAccountBy = accountManagerDao.findAccountBy(id);
		return findAccountBy;
	}

	@Override
	public RegisteredAccount findAccountBy(Account account) {
		long id = account.getId();
		
		if(id>0){
			return accountManagerDao.findAccountBy(id);
		}
		
		List<RegisteredAccount> foundList = accountManagerDao.findAccountBy(account);
		if(null != foundList &&  ! foundList.isEmpty()){
			return foundList.get(0);
		}
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
