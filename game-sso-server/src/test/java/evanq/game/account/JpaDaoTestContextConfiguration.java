package evanq.game.account;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class JpaDaoTestContextConfiguration {

	@Bean
	public DataSource dataSource(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.H2);
		//EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("data.sql").build();
		return builder.build();
		
	}
	
//	@PersistenceUnit(unitName = "itcast") 
//    protected EntityManagerFactory entityManagerFactory ; 
//	@Bean
//	public EntityManagerFactory entityManagerFactory(){
//		return Persistence.createEntityManagerFactory("itcast");
//	}
	
	@Bean
	public AccountManagerDao accountManagerDao(){
		return new JpaAccountManagerDaoImpl();
	}
}
