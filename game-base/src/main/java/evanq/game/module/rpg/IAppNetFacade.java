package evanq.game.module.rpg;

/**
 * 
 * 应用层调用网络的门面
 * 
 * @author Evan
 *
 */
public interface IAppNetFacade {

	public void write(/** MSG  */);
	
	public void write(/** MSG  */int broadLvl /** 广播的级别 */);
	
}
