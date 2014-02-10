package evanq.game.account;

import java.util.List;

public interface AccountManagerDao {
	
	public RegisteredAccount save(RegisteredAccount registeredAccount);
	
	public boolean delete(RegisteredAccount registeredAccount);
	
	public RegisteredAccount findAccountBy(long id);
	
	public List<RegisteredAccount> load();
	
	public List<RegisteredAccount> load(int start,int length);
}
