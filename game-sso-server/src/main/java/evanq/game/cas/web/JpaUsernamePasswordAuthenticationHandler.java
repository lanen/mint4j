package evanq.game.cas.web;

import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sun.istack.NotNull;

import evanq.game.account.AccountManager;
import evanq.game.account.RegisteredAccount;

public class JpaUsernamePasswordAuthenticationHandler extends
		AbstractUsernamePasswordAuthenticationHandler {

	@NotNull
	private AccountManager accountManager;
	
	@NotNull
	private UserDetailsService userDetailsService;
	
	
	@Override
	protected boolean authenticateUsernamePasswordInternal(
			UsernamePasswordCredentials credentials)
			throws AuthenticationException {
		
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		String encryptedPassword = this.getPasswordEncoder().encode(
		            password);
		//来自账号服务器的验证
		CasLoginAccount casLoginAccount = new CasLoginAccount(username);
		RegisteredAccount findAccountBy = accountManager.findAccountBy(casLoginAccount);
		if(null != findAccountBy){
			return encryptedPassword.equals(findAccountBy.getPasswd());
		}
		if("admin1".equals(username)){
			System.out
					.println("JpaUsernamePasswordAuthenticationHandler.authenticateUsernamePasswordInternal()");
			System.err.println("让测试账号admin1 通过验证");
			return true;
		}
		//Server Manager 账号验证
		try{
			
			UserDetails loadUserByUsername = userDetailsService.loadUserByUsername(username);
			if(null != loadUserByUsername){
				return password.equals(loadUserByUsername.getPassword()); 
			}
		}catch(UsernameNotFoundException e){
			
		}
		return false;
		
	}


	public AccountManager getAccountManager() {
		return accountManager;
	}


	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}


	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}


	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
}
