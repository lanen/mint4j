package evanq.game.account;

import java.util.List;


public interface AccountManagerDao {
	
	public static final String ACCOUNT_UNIT_NAME = "accounts";
	
	public RegisteredAccount save(RegisteredAccount registeredAccount);
	
	public boolean delete(RegisteredAccount registeredAccount);
	
	public RegisteredAccount findAccountBy(long id);
	public List<RegisteredAccount> findAccountBy(Account account);
	
	public List<RegisteredAccount> load();
	
	public List<RegisteredAccount> load(int start,int length);
}
