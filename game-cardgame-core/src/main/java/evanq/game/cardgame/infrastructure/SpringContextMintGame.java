package evanq.game.cardgame.infrastructure;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextMintGame {

	protected ClassPathXmlApplicationContext ctx;
	
	public SpringContextMintGame(String[] filenames){
		ctx = new ClassPathXmlApplicationContext(filenames);
	}
	
	public <T> T getBean(Class<T> clazz) {
		return ctx.getBean(clazz);
	}
}
