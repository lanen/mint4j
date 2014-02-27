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
	 * @return
	 */
	Realm recommendRealm();
	
}
