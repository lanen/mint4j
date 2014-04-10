package evanq.game.cardgame.interfaces.role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.cardgame.application.UCPlayer;
import evanq.game.cardgame.interfaces.dto.LoginDTO;
import evanq.game.infrastructure.mint.commandexecutors.annotation.Executor;

/**
 * 
 * 登陆控制器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
/*@CommandExecutor(LoginDTO.class)*/
@Executor
public class LoginController /*implements CommandListener<LoginDTO>*/ {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private UCPlayer player;
	/*
	@Override
	public void action(LoginDTO t) {
		
		player.login();
		
		//TODO step 2. 登陆日志
		
		//TODO step 3. 登陆授权（针对管理员）
		
		
	}*/

	@Executor(LoginDTO.class)
	public void executor_login(LoginDTO t){
		System.out.println("LoginController.executor_login()");
		
	}
	public UCPlayer getPlayer() {
		return player;
	}

	public void setPlayer(UCPlayer player) {
		this.player = player;
	}
	
}
