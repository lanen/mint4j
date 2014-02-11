package evanq.game.account;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes={JpaDaoTestContextConfiguration.class})
public class JpaAccountManagerDaoImplTest {

	@Autowired
	private AccountManagerDao accountManagerDao;
	
	
	@Test
	public void testSave() {
		
		System.out.println(accountManagerDao);
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
	    EntityManager entityManager = factory.createEntityManager();
	    entityManager.getTransaction().begin();
	    
	    
	    RegisteredAccount account = registeredAccount();
	    entityManager.persist(account);
	    
	    entityManager.getTransaction().commit();
	    entityManager.close();
	    factory.close();
	}
	
	private RegisteredAccount registeredAccount(){
		RegisteredAccountImpl impl = new RegisteredAccountImpl();
		impl.setAccount("test");
		return impl;
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAccountBy() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoad() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadIntInt() {
		fail("Not yet implemented");
	}

}
