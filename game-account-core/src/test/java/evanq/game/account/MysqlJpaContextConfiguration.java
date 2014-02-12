package evanq.game.account;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "evanq.game.account")
@EnableTransactionManagement
public class MysqlJpaContextConfiguration extends JpaDaoTestContextConfiguration {
	
	public MysqlJpaContextConfiguration() {
		super("h2");
	}

}
