package evanq.game.cardgame.application.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.cardgame.application.UCRole;
import evanq.game.cardgame.domain.model.role.RoleId;

public class UCRoleImpl implements UCRole {

	private Logger logger = LoggerFactory.getLogger(UCRoleImpl.class);
	
	
	@Override
	public void enterGame(RoleId roleId) {

		logger.info("角色进入游戏");
	
		
	}

	@Override
	public void leaveGame(RoleId roleId) {

		logger.info("角色离开游戏");
	}

	@Override
	public void wasKill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub
		
	}

	
}
