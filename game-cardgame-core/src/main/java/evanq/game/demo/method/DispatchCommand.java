package evanq.game.demo.method;

import java.util.ArrayList;
import java.util.List;

public class DispatchCommand {

	
	private List<CommandMapping> commandMappings;
	
	private List<CommandAdaptor> commandAdaptors;
	
	protected void initCommandMappings(){
		this.commandMappings = new ArrayList<CommandMapping>();
	}
	
	protected void initCommandAdaptors(){
		this.commandAdaptors = new ArrayList<CommandAdaptor>();
	}
	
	public void dispatch(Object command){
		
		//step 1: 查找 CommandMapping 获取 CommandExecutor
		//step 2  执行 CommandExecutor
		
		int opcode = 0;
		
		CommandExecutorChain executor = getExecutor(opcode);
		
		CommandAdaptor commandAdaptor = getCommandAdaptor(executor.getExecutor());
		
		commandAdaptor.execute(command, executor.getExecutor());
		
	}
	
	CommandExecutorChain getExecutor(int opcode){
		for (CommandMapping cm : commandMappings) {
			try {
				CommandExecutorChain executor = cm.getExecutor(opcode);
				if(null != executor){
					return executor;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	CommandAdaptor getCommandAdaptor(Object command){
		for (CommandAdaptor a : commandAdaptors) {
			if(a.supports(command)){
				return a;
			}
		}
		
		//TODO 抛出不支持异常
		return null;
	}
}
