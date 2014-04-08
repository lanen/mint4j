package evanq.game.infrastructure.mint.protocol;

import java.util.Map;

import evanq.game.helper.New;
import evanq.game.infrastructure.mint.CommandExecutorRegistry;
import evanq.game.infrastructure.mint.CommandListener;

/**
 * Just in test.
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class InMemoryCommandExecutorResolver implements CommandExecutorRegistry.CommandListenerResolver {

	
	private Map<String,CommandListener<?>> commandListeners = New.hashMap();
	
	@Override
	public CommandListener<?> resolver(Class<CommandListener<?>> clazz) {
		if(commandListeners.containsKey(clazz.getName())){
			return commandListeners.get(clazz.getName());
		}
		
		try {
			CommandListener<?> newInstance = clazz.newInstance();
			return newInstance;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CommandListener<?> resolver(String name,
			Class<CommandListener<?>> clazz) {

		if(commandListeners.containsKey(clazz.getName())){
			return commandListeners.get(clazz.getName());
		}
		
		try {
			CommandListener<?> newInstance = clazz.newInstance();
			return newInstance;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
