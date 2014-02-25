package evanq.game.web.login;

/**
 * 登陆、注册、注销、忘记密码都需要独立配置URL,改类经过入参后得到最终地址
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public interface URLTemplate {

	public String format(Object... args) ;
	
	//这里考虑a[]=s1&a[]=s2这种类型的参数
	public URLTemplate append(String key,String value, boolean doURLEncode);
	
}
