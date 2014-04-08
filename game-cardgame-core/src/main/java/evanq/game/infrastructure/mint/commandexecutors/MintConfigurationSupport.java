package evanq.game.infrastructure.mint.commandexecutors;

import evanq.game.infrastructure.mint.commandexecutors.klass.KlassCommandAdaptor;
import evanq.game.infrastructure.mint.commandexecutors.method.MethodCommandAdaptor;

/**
 * 
 * 驱动框架的配置
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class MintConfigurationSupport {

	
	/**
	 * 
	 * 通过注解定义的处理器
	 * 
	 * method controler
	 * 
	 * @return
	 */
	public MethodCommandAdaptor methodCommandAdaptor (){
		
		MethodCommandAdaptor adaptor = new MethodCommandAdaptor();
		
		return adaptor;
	}
	
	/**
	 * 
	 * 实现了 CommandExecutor 接口的处理器
	 * @return
	 */
	public KlassCommandAdaptor klassCommandAdaptor(){
		
		KlassCommandAdaptor klassCommandAdaptor = new KlassCommandAdaptor();
		
		return klassCommandAdaptor;
	}
	
	
}
