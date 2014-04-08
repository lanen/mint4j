package evanq.game.infrastructure.mint.commandexecutors.method;

import java.lang.reflect.Method;

import evanq.game.infrastructure.mint.commandexecutors.CommandAdaptor;

public class MethodCommandAdaptor implements CommandAdaptor {

	
	
	@Override
	public boolean supports(Object executor) {
		return false;
	}

	@Override
	public void execute(Object command, Object executor) {
		
	}
	
}
