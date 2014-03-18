package evanq.game.cardgame.application.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.cardgame.application.UCPlayer;
import evanq.game.cardgame.application.UCRole;
import evanq.game.cardgame.domain.model.role.RoleInfo;
import evanq.game.cardgame.domain.service.IRoleService;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class UCPlayerImpl implements UCPlayer {

	private Logger logger = LoggerFactory.getLogger(UCPlayerImpl.class);
	
	private IRoleService roleService;
	
	@Override
	public void login() {
		// TODO Auto-generated method stub
		logger.info("登陆成功");
	
		RoleInfo roleInfo = roleService.findRoleInfo(null);
		roleService.enterWorld(roleInfo);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleleRole() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createRole() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRole() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listRoles() {
		// TODO Auto-generated method stub

	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	

}
