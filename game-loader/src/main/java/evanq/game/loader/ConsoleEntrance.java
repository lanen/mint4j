package evanq.game.loader;

import evanq.game.impl.RoleEngine;
import evanq.game.impl.World;
import evanq.game.module.IModule;


/**
 * 
 * 游戏的命令行入口
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ConsoleEntrance 
{
    public static void main( String[] args )
    {
       //解析命令行参数（来自命令行的参数优先级高于文件配置）
        
    	
    	//1.将模块注册进来
    	//2.模块静态诊断
    	//3.模块加载
    	//4.正式服务器
    	//5.退出，模块卸载

    	RoleEngine.getInstance();
    	
    	World.getInstance().start();    	
    	
    }
    
    public static void moduleSupport(){
    	
    	RoleEngine.getInstance().setModule(null);
    	
    	IModule[] staticModuleForGame = new IModule[]{
    	};
    	int ready = 0;
    	for (int i = 0; i < staticModuleForGame.length; i++) {
    		int prepareState = staticModuleForGame[i].prepareState();
    		//这里根据模块的预加载状态，来输出命令
    		System.out.println(staticModuleForGame[i]);
    		if(prepareState>0){
    			ready = -1;
    		}
		}
    	
    	if(-1 == ready){
    		
    		System.out.println("模块检查出问题。。。");
    		return;
    	}
    	    	
    }
}
