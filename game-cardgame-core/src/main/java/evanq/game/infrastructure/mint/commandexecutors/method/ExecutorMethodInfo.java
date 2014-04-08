package evanq.game.infrastructure.mint.commandexecutors.method;

public final class ExecutorMethodInfo {

	/**
	 * 该方法对应的命令编号
	 */
	private int commandId;
	
	
	private int hash;


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


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
