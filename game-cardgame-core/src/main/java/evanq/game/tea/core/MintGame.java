package evanq.game.tea.core;

import evanq.game.cardgame.domain.model.world.GameWorld;
import evanq.game.cardgame.infrastructure.SpringContextMintGame;

public class MintGame {

	public static void main(String[] args) {
		
		String[] cpXMLs = new String[]{
			"classpath:cardgame-application.xml",
			"classpath:cardgame-domain.xml",
			"classpath:cardgame-infrastructure.xml",
			"classpath:cardgame-interfaces.xml"
		};
		
		SpringContextMintGame mintGame = new SpringContextMintGame(cpXMLs);
		
		GameWorld beanOfGameWorld = mintGame.getBean(GameWorld.class);
		beanOfGameWorld.start();
		
	}
}
