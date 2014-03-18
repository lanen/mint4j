package evanq.game.cardgame.domain.service;

import evanq.game.cardgame.domain.model.role.RoleId;
import evanq.game.cardgame.domain.model.role.RoleInfo;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface IRoleService {
	
	/**
	 * 
	 * @param roleId
	 * @return
	 */
	public RoleInfo findRoleInfo(RoleId roleId);
	
	/**
	 * 
	 * @param roleInfo
	 */
	public void enterWorld(RoleInfo roleInfo);
	
	/**
	 * @param roleInfo
	 */
	public void leaveWorld(RoleInfo roleInfo);

}
