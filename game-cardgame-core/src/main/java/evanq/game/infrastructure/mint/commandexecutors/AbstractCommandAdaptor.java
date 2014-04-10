package evanq.game.infrastructure.mint.commandexecutors;

import evanq.game.infrastructure.mint.commandexecutors.method.ExecutorMethod;

public abstract class AbstractCommandAdaptor implements CommandAdaptor {

	@Override
	public boolean supports(Object executor) {
		
		if( !(executor instanceof ExecutorMethod))return false;
		
		return supportsInternal((ExecutorMethod)executor);
	}

	protected abstract boolean supportsInternal(ExecutorMethod executorMethod);
	
	protected abstract void executeInternal(Object command, ExecutorMethod executorMethod);

	
	@Override
	public void execute(Object command, Object executor) {
		// TODO Auto-generated method stub
		executeInternal(command, (ExecutorMethod) executor);
	}
}
