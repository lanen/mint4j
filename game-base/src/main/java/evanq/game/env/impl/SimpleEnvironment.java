package evanq.game.env.impl;

import evanq.game.database.DB;
import evanq.game.env.IEnvironment;
import evanq.game.helper.DeadLockDetector;
import evanq.game.utils.AttributeMap;

/**
 * 
 * 运行环境
 * 
 * evn has many IOption 
 * @author Evan
 * 
 */
public class SimpleEnvironment implements IEnvironment {

	
	@Override
	public IEnvironment accept(AttributeMap option) {
		return this;
	}

	@Override
	public IEnvironment notifySetup() {
		if( ! hasInitOptions() ){
			throw new IllegalAccessError("没有提供配置项");
		}
		
		try {
			// 日志
			//PropertyConfigurator.configure("config/log4j.properties");

			// Spring 引擎
			//DIEngine.getInstance().start();

			// 数据库
			DB.getInstance().setupDB(this);		
	
			// 用于运行时线程死锁检查
			DeadLockDetector d = new DeadLockDetector(60,
					DeadLockDetector.RESTART);
			d.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	void initOptions(){
		
	}
	
	/**
	 * 
	 * 验证必须的参数
	 * 
	 */
	void validateRequiredOptions(){
		
	}
	
	/**
	 * 检测是否有配置项
	 * @return
	 */
	boolean hasInitOptions(){
		return true;
	}

	@Override
	public boolean isValidForRunning() {
		return true;
	}

	@Override
	public void dump() {
		System.exit(-1);
	}

	@Override
	public void refress() {
		
		initOptions();
		validateRequiredOptions();

	}

}
