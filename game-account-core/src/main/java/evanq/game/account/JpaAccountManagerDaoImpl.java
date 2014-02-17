package evanq.game.account;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountManagerDao")
public class JpaAccountManagerDaoImpl implements
		AccountManagerDao {
	
	@PersistenceUnit(unitName="accounts")
	private EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public RegisteredAccount save(RegisteredAccount registeredAccount) {
		entityManager.persist(registeredAccount);
		return registeredAccount;
	}
	
	@Transactional
	@Override
	public boolean delete(RegisteredAccount registeredAccount) {
		entityManager.remove(entityManager.merge(registeredAccount));
		return true;
	}

	@Override
	public RegisteredAccount findAccountBy(long id) {
		RegisteredAccount find = entityManager.find(RegisteredAccountImpl.class, id);
		return find;
	}
	
	@Transactional
	@Override
	public List<RegisteredAccount> findAccountBy(Account account) {
		
		TypedQuery<RegisteredAccount> query = entityManager.createQuery("select a from RegisteredAccountImpl a where a.account = ?1",RegisteredAccount.class);
		query.setParameter(1, account.getAccount());
		List<RegisteredAccount> resultList = query.getResultList();
		return  resultList;
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
