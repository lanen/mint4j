package evanq.game.account;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


public abstract class JpaDaoTestContextConfiguration {
	
	private String unitName;
	
	protected JpaDaoTestContextConfiguration(String unitName) {
		if(null == unitName){
			throw new NullPointerException("unitName");
		}
		this.unitName = unitName;
	}

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager m = new JpaTransactionManager();
		m.setEntityManagerFactory(entityManagerFactory);
		return m;
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {

		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName(unitName);
		return bean;
	}
}
