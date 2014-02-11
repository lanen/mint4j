package evanq.game.account;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class JpaAccountManagerDaoImpl implements
		AccountManagerDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
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
