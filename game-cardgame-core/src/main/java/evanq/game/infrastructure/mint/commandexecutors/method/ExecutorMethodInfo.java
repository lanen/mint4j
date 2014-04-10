package evanq.game.infrastructure.mint.commandexecutors.method;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * 方法执行器的 的描述信息
 * @author Evan cppmain@gmail.com
 *
 */
public final class ExecutorMethodInfo {

	
	private static final Map<Integer,ExecutorMethodInfo> cache = new HashMap<Integer,ExecutorMethodInfo>();
	
	public static final ExecutorMethodInfo DUMMY = new ExecutorMethodInfo(0);
	/**
	 * 该方法对应的命令编号
	 */
	private int commandId;
	
	
	private int hash;

	public ExecutorMethodInfo(int cmdId){
		
		this.commandId = cmdId;
		
		cache.put(this.commandId, this);
	}

	
	public int getCommandId() {
		return commandId;
	}

	@Override
	public int hashCode() {
		
		int result = hash;
		if (result == 0) {
			result = Integer.valueOf(commandId).hashCode();
			hash = result;
		}
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj instanceof ExecutorMethodInfo){
			ExecutorMethodInfo that = (ExecutorMethodInfo)obj;
			return this.commandId == that.commandId;
		}
		return false;
	}

	public static ExecutorMethodInfo valueOf(int cmd){
		if(!cache.containsKey(cmd))return DUMMY;
		return cache.get(cmd);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
