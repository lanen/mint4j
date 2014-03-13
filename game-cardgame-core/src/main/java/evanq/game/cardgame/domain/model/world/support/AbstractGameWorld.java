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
	private Collection<GameWorldPart> gameWorldParts ;
	
	protected boolean initialized;

	public AbstractGameWorld() {
		
		gameWorldParts = new LinkedList<GameWorldPart>();
		
		BasicGameWorldPart basicPart = new BasicGameWorldPart();
		gameWorldParts.add(basicPart);
//		
//		EntitySystemGameWorldPart esPart = new EntitySystemGameWorldPart();
//		gameWorldParts.add(esPart);
//		
	
	}
	
	protected void initialze(){
 		if(!initialized){
			
			for (GameWorldPart b : gameWorldParts) {
				b.buildPart();
			}
			initialized = true;
		}
	}

	
	public Collection<GameWorldPart> getGameWorldParts() {
		return gameWorldParts;
	}

	public void setGameWorldParts(Collection<GameWorldPart> gameWorldParts) {
		if(null != gameWorldParts && !gameWorldParts.isEmpty()){
			this.gameWorldParts.addAll(gameWorldParts);
		}
	}

}
