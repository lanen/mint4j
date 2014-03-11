package evanq.game.cardgame.domain.model.world.support;

import java.util.Collection;
import java.util.LinkedList;

import evanq.game.cardgame.domain.model.world.GameWorld;
import evanq.game.cardgame.domain.model.world.GameWorldPart;

/**
 * 
 * �����ֳɶ���������ɣ������ԾۺϷ�ʽ����һ������
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
