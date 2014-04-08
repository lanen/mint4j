package evanq.game.demo.method.test;

import evanq.game.infrastructure.mint.commandexecutors.annotation.Executor;

@Executor
public class HandlerOne {

	@Anno
	public void dummy(){

		System.out.println("HandlerOne.dummy()");
	}
}
