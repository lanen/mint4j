package evanq.game.account;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes={DefaultAccountManagerContextConfiguration.class})

public class DefaultAccountManagerImplTest {

	@BeforeClass
	public static void initClass(){
		
	}
	
	@AfterClass
	public static void destoryClass(){
		
	}
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	public void testSave() {
		System.out.println("D");
		
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAccountByLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAccountByAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testMatchesExistingAccount() {
		fail("Not yet implemented");
	}

}
