package evanq.game.cardgame.domain.service.impl;

import evanq.game.cardgame.domain.model.role.RoleId;
import evanq.game.cardgame.domain.model.role.RoleInfo;
import evanq.game.cardgame.domain.model.role.RoleRepository;
import evanq.game.cardgame.domain.service.IRoleService;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class RoleServiceImpl implements IRoleService {

	private RoleRepository roleRepository;
	
	@Override
	public RoleInfo findRoleInfo(RoleId roleId) {
		return null;
	}

	@Override
	public void enterWorld(RoleInfo roleInfo) {
		
		
		
		
		
	}

	@Override
	public void leaveWorld(RoleInfo roleInfo) {
		
		
		
		
	}

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
}
