package evanq.game.cardgame.interfaces.player;

import evanq.game.cardgame.infrastructure.mint.CommandExecutor;
import evanq.game.cardgame.infrastructure.mint.CommandListener;
import evanq.game.cardgame.interfaces.dto.LogoutDTO;

/**
 * 
 * 登陆控制器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
@CommandExecutor(LogoutDTO.class)
public class AccountController implements CommandListener<LogoutDTO> {
	
	
	@Override
	public void action(LogoutDTO t) {

		
		System.out.println('f');
	}
	
	
	
}
