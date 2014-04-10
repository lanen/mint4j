package evanq.game.infrastructure.mint.commandexecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import evanq.game.cardgame.interfaces.dto.LoginDTO;
import evanq.game.infrastructure.WorldUtils;
import evanq.game.infrastructure.mint.commandexecutors.method.MethodCommandAdaptor;
import evanq.game.infrastructure.mint.commandexecutors.method.MethodCommandMapping;
import evanq.game.net.DefaultPacketAllocator;
import evanq.game.utils.OrderComparator;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DispatchCommand {
	

	//这些是命令与命令执行器的映射
	private List<CommandMapping> commandMappings;
	
	//这些适配器是为了执行命令
	private List<CommandAdaptor> commandAdaptors;
	
	private DispatchCommand() {
	}
	
	/**
	 * 
	 * 
	 */
	protected void initCommandMappings(){
		
		if(null != this.commandMappings){
			this.commandMappings.clear();
			this.commandMappings = null;
		}

		//TODO 初始化所有实现 CommandMapping 的对象
		
		Map<String, CommandMapping> matchingBeans = WorldUtils.beanResolver().beansOfTypeIncludingAncestors(CommandMapping.class, true, false);
		
		if(! matchingBeans.isEmpty()){
			this.commandMappings = new ArrayList<CommandMapping>(matchingBeans.values());
			
			//排序映射集合，比较重要。数据进来时候，处理有优先之别
			OrderComparator.sort(this.commandMappings);
		}
		
		//TODO 保证能够有一个默认的映射，在开发环境下，能够正常运行
		if(null == this.commandMappings){
			this.commandMappings = new ArrayList<CommandMapping>();
			
			MethodCommandMapping bean = (MethodCommandMapping)WorldUtils.beanResolver().getBean(MethodCommandMapping.class, true);
			bean.setOrder(1);
			this.commandMappings.add(bean);
			OrderComparator.sort(this.commandMappings);
		}
	}
	
	/**
	 * 
	 * 
	 */
	protected void initCommandAdaptors(){
		
		
		if(null == this.commandAdaptors){
			
			this.commandAdaptors = new ArrayList<CommandAdaptor>();
			
			MethodCommandAdaptor bean =(MethodCommandAdaptor) WorldUtils.beanResolver().getBean(MethodCommandAdaptor.class,true);
			this.commandAdaptors.add(bean);
		}
		
		//TODO 
		
	}
	
	public void initDispatchCommand(){
			
		initCommandAdaptors();
		initCommandMappings();		
	}
	
	
	public void dispatch(Object command){
		
		//step 1: 查找 CommandMapping 获取 CommandExecutor
		//step 2  执行 CommandExecutor
			
		CommandExecutionChain executor = getExecutor(command);

		if(null == executor){
			System.out.println("找不到");
			return;
		}
		CommandAdaptor commandAdaptor = getCommandAdaptor(executor.getExecutor());
		if(null != commandAdaptor){
			commandAdaptor.execute(command, executor.getExecutor());
		}else{
			//TODO NOT COMMAND FOOUND
		}
		
	}
	
	CommandExecutionChain getExecutor(Object command){
		//遍历所有的映射器，查找到处理器的适配器
		
		for (CommandMapping cm : commandMappings) {
			try {
				CommandExecutionChain executor = cm.getExecutor(command);
				if(null != executor){
					return executor;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * 判断是否支持，命令与执行器是否兼容
	 * @param command
	 * @return
	 */
	CommandAdaptor getCommandAdaptor(Object command){
		for (CommandAdaptor a : commandAdaptors) {
			if(a.supports(command)){
				return a;
			}
		}
		
		//TODO 抛出不支持异常
		return null;
	}
	
	private static class Singleton{
		public static final DispatchCommand INSTANCE = new DispatchCommand();
	}

	public static DispatchCommand getInstance(){
		return Singleton.INSTANCE;
	}
		
}
