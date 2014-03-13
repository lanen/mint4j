package evanq.game.cardgame.interfaces.role;

import evanq.game.cardgame.infrastructure.mint.CommandExecutor;
import evanq.game.cardgame.infrastructure.mint.CommandListener;
import evanq.game.cardgame.interfaces.dto.LoginDTO;

/**
 * 
 * 登陆控制器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
@CommandExecutor(LoginDTO.class)
public class LoginController implements CommandListener<LoginDTO> {

	
	
	@Override
	public void action(LoginDTO t) {
		
	}
	
}
