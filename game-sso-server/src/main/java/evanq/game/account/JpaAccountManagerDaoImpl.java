package evanq.game.account;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

public class JpaAccountManagerDaoImpl extends JpaDaoSupport implements
		AccountManagerDao {

	@Override
	public RegisteredAccount save(RegisteredAccount registeredAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(RegisteredAccount registeredAccount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RegisteredAccount findAccountBy(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegisteredAccount> load() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegisteredAccount> load(int start, int length) {
		// TODO Auto-generated method stub
		return null;
	}

}
