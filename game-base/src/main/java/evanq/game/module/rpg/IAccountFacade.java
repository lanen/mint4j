package evanq.game.module.rpg;

/**
 * 
 * 账号模块公布出来的接口
 * 
 * 账号需要一个状态机
 * 
 * @author Evan
 *
 */
public interface IAccountFacade {

	public void signin();
	public void signoff();
	public void delete();
	public void signup();
	public void active();
	public void deactive();
	public void ban();
	public void deBan();
	
}
