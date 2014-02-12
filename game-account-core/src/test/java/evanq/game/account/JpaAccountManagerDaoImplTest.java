package evanq.game.account;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes={MysqlJpaContextConfiguration.class})
public class JpaAccountManagerDaoImplTest {

	@Autowired
	private AccountManagerDao accountManagerDao;
	
	@Test
	public void testSave() {
		
		System.out.println("开始持久化测试");
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
//		EntityManager createEntityManager = factory.createEntityManager();
//		System.out.println(factory);
//		RegisteredAccount entity = registeredAccount();
//		createEntityManager.getTransaction().begin();
//		createEntityManager.persist(entity);
//		createEntityManager.getTransaction().commit();
//		createEntityManager.close();
//		factory.close();
		
		RegisteredAccount account = registeredAccount();
//		EntityManager d = entityManagerFactory.createEntityManager();
//		d.getTransaction().begin();
//		d.persist(account);
//		d.getTransaction().commit();
		RegisteredAccount saveAccountResult = accountManagerDao.save(account);
		
		assertNotNull("保存账号失败",saveAccountResult);
		
		RegisteredAccount findAccountBy = accountManagerDao.findAccountBy(account.getId());
		assertNotNull("取出保存的对象失败",findAccountBy);
//		
		System.out.println("持久化账号测试成功");

	}
	
	private RegisteredAccount registeredAccount(){
		RegisteredAccountImpl impl = new RegisteredAccountImpl();
		impl.setAccount("test");
		impl.setState(1);
		impl.setEmail("cppmain@gmail.com");
		impl.setFlag(1);
		impl.setMobile("15919710160");
		impl.setAccount("passwd");
		return impl;
	}

	@Test
	public void testDelete() {
		//新建一个账号
		RegisteredAccount account = registeredAccount();
		RegisteredAccount saveAccountResult = accountManagerDao.save(account);
		
		//删除该账号
		
		long theDeleteId= saveAccountResult.getId();
		System.out.println("即将删除 id:"+theDeleteId);
		accountManagerDao.delete(saveAccountResult);
		
		//查询是否存在
		RegisteredAccount findAccountBy = accountManagerDao.findAccountBy(theDeleteId);
		assertNull("删除对象失败 id:" + theDeleteId ,findAccountBy);
		
		System.out.println("删除 id:"+theDeleteId);
	}

	@Test
	public void testFindAccountBy() {
	}

	@Test
	public void testLoad() {
	}

	@Test
	public void testLoadIntInt() {
	}

}
