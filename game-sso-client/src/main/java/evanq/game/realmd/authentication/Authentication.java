package evanq.game.realmd.authentication;

import evanq.game.realmd.authentication.principal.Principal;


/**
 * 
 * The Authentication object represents a successful authentication request
 * 
 * 一条的成功授权
 * 
 * 
 * 内测游戏授权
 * 
 * 公测游戏授权
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface Authentication {
	
	Principal getPrincipal();
	
}
