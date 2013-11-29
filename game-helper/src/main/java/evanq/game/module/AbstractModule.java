package evanq.game.module;

/**
 * 
 * 游戏模块的抽象
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractModule implements IModule {

	protected String moduleName;
	
	protected ModuleState moduleState = ModuleState.UNKOWN;
	
	@Override
	public int prepareState() {
		return 0;
	}

	@Override
	public void load() {

	}

	@Override
	public void offLoad() {

	}

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(moduleName).append("... ... ...");
		buffer.append('[').append(moduleState).append(']').append('\n');
		return buffer.toString();
	}
}
