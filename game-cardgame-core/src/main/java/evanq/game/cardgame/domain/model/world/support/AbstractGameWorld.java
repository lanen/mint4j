package evanq.game.cardgame.domain.model.world.support;

import java.util.Collection;
import java.util.LinkedList;

import evanq.game.cardgame.domain.model.world.GameWorld;
import evanq.game.cardgame.domain.model.world.GameWorldPart;

/**
 * 
 * 程序拆分成多个部件构成，部件以聚合方式组在一起搭建服务
 * 
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractGameWorld implements GameWorld {
	
	/**
	 * 
	 */
	private Collection<GameWorldPart> worldBuilders ;
	

	public AbstractGameWorld() {
		
		worldBuilders = new LinkedList<GameWorldPart>();
		
		BasicGameWorldPart basicPart = new BasicGameWorldPart();
		worldBuilders.add(basicPart);
		
		EntitySystemGameWorldPart esPart = new EntitySystemGameWorldPart();
		worldBuilders.add(esPart);
		
		for (GameWorldPart b : worldBuilders) {
			b.buildPart();
		}		

	}

	
	public Collection<GameWorldPart> getWorldBuilders() {
		return worldBuilders;
	}

	public void setWorldBuilders(Collection<GameWorldPart> worldBuilders) {
		this.worldBuilders = worldBuilders;
	}

}
