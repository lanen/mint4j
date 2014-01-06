package evanq.game.env;

import evanq.game.utils.AttributeMap;

/**
 * 
 * 运行游戏世界的环境
 * 
 * <pre>
env.accept(sysprop);
env.accept(option);

env.refress();

if( ! env.isValidForRunning()){
	env.dump();
}
	
env.notifySetup();
	</pre>
 * @author Evan
 *
 */
public interface IEnvironment {

	//获取环境参数
	public IEnvironment accept(AttributeMap option);
	
	//环境解释参数
	public IEnvironment notifySetup();
	
	public void refress();
	
	/**
	 * 环境是否可以继续运行
	 * @return
	 */
	public boolean isValidForRunning();
	
	public void dump();
}
