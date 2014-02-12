package evanq.game.account;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface AccountManager {
	
	public RegisteredAccount save(RegisteredAccount registeredAccount);
	
	public RegisteredAccount delete(long id);
	
	public RegisteredAccount findAccountBy(long id);
	
	public RegisteredAccount findAccountBy(Account account);
	
	boolean matchesExistingAccount(Account account);
}
