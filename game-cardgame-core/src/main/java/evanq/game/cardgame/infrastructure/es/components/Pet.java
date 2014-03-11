package evanq.game.cardgame.infrastructure.es.components;

import com.artemis.Component;

public class Pet extends Component {

	private String name;
	
	private int ownerId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
}
