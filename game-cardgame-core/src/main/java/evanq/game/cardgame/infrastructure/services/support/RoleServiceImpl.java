package evanq.game.cardgame.infrastructure.services.support;

import evanq.game.cardgame.domain.model.role.RoleId;
import evanq.game.cardgame.domain.model.role.RoleInfo;
import evanq.game.cardgame.domain.model.role.RoleRepository;
import evanq.game.cardgame.domain.model.world.support.WorldUtils;
import evanq.game.cardgame.domain.service.IRoleService;
import evanq.game.cardgame.infrastructure.services.EntitySystemService;
import evanq.game.cardgame.infrastructure.services.IPostContrust;

/**
 * @author Evan cppmain@gmail.com
 *
 */
public class RoleServiceImpl implements IRoleService, IPostContrust {

	private EntitySystemService entitySystemService;
	
	private RoleRepository roleRepository;
	
	@Override
	public RoleInfo findRoleInfo(RoleId roleId) {
		return null;
	}

	@Override
	public void enterWorld(RoleInfo roleInfo) {
		entitySystemService.addRole();
	}

	@Override
	public void leaveWorld(RoleInfo roleInfo) {
		
		entitySystemService.removeRole();
	}

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public void atfterStart() {
		System.out.println("RoleServiceImpl.atfterStart()");
		
		if(null == entitySystemService){
			System.out.println("playerEntityController init");
			entitySystemService = WorldUtils.services().get(EntitySystemService.class);
		}
	}
}
