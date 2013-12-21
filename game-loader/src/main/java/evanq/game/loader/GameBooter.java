package evanq.game.loader;

import evanq.game.env.impl.ConsoleArgumentOptions;
import evanq.game.env.impl.SimpleEnvironment;
import evanq.game.env.impl.SystemPropertyOptions;
import evanq.game.module.rpg.IWorldFacade;
import evanq.game.rpg.impl.WorldInstance;

/**
 * 
 * @author Evan
 *
 */
public class GameBooter {

	public static void main(String[] args) throws Exception {
		Impl(args);		
	}
	
	public static void Impl(String[] args){		
		
		//step 1. 封装来自命令行的参数
		
		SystemPropertyOptions sysprop = new SystemPropertyOptions();
		ConsoleArgumentOptions option = new ConsoleArgumentOptions(args);
		
		//step 2. 准备游戏世界
		SimpleEnvironment env = new SimpleEnvironment();
	
		env.accept(sysprop);
		env.accept(option);
		
		env.refress();
		
		if( ! env.isValidForRunning()){
			env.dump();
		}
		
		env.notifySetup();
		
		//step 3. 建立游戏世界实例
		IWorldFacade world = WorldInstance.get();
		world.start("钓鱼岛",env);
		
	}
	
}
