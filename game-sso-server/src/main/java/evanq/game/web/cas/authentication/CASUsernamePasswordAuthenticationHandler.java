package evanq.game.web.cas.authentication;

import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;

import evanq.game.account.dao.IAccountDao;

public class CASUsernamePasswordAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

	private IAccountDao accountDao;
	
	@Override
	protected boolean authenticateUsernamePasswordInternal(
			UsernamePasswordCredentials credentials) throws AuthenticationException {
		
		
		return false;
	}

	public IAccountDao getAccountDao() {
		return accountDao;
	}
	

}
