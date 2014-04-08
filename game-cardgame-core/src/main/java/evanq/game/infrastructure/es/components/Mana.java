package evanq.game.infrastructure.es.components;

import com.artemis.Component;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class Mana extends Component {

	private int mp;
	
	private int maxMp;

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}
	
	
}
