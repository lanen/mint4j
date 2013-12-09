package evanq.game.event.selector;

import evanq.game.event.MintConsumer;
import evanq.game.event.reactor.MintReactor;
import evanq.game.helper.New;
import evanq.game.helper.Registry;

public class Selectors {
	
	
	private Registry<String, MintSelector> selectors = New.registry();	
	
	public void registrySelector(String name,MintSelector selector){
		selectors.put(name, selector);
	}
	

}
