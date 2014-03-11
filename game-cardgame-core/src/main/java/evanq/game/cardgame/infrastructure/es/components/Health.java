package evanq.game.cardgame.infrastructure.es.components;

import com.artemis.Component;

public class Health extends Component {

	private int health;
	
	private int maxHealth;

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
}
