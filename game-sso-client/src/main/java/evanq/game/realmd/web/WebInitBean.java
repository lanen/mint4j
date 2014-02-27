package evanq.game.realmd.web;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;


public class WebInitBean implements InitializingBean,ServletContextAware {

	private Logger logger = LoggerFactory.getLogger(WebInitBean.class);
	
	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		logger.info("完成启动 {}",this.servletContext);
	}

}
