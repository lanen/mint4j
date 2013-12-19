package evanq.game.scene;

import evanq.game.concurrent.loop.ICommand;

public class CreateSceneCommand implements ICommand {

	@Override
	public void execute() {
		
		System.err.println("创建场景 "+ Thread.currentThread());
	}

}
