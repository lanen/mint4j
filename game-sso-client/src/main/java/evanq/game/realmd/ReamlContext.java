package evanq.game.realmd;

/**
 * 
 * 游戏分区的上下文
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface ReamlContext {


	RealmRegistry registry();
	
	/**
	 * 推荐服务器
	 * 需要一个游戏分区推荐表
	 * @return
	 */
	@Deprecated
	Realm recommendRealm();
	
}
