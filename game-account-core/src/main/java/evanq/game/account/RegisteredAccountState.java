package evanq.game.account;

/**
 * 
 * 账号的状态
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public enum RegisteredAccountState {

	/** 新注册账号 */
	ACCOUNT_NEW(1),
	/** 等待手机验证 */
	ACCOUNT_SETTING_MOBILE(2),
	
	/** 等待邮件验证  */
	ACCOUNT_SETTING_DETAIL(4),
	
	/** 完成注册账号 */
	ACCOUNT_FINISHED_REGISTER(8);
	private int v;
	
	private RegisteredAccountState(int v){
		this.v = v;
	}
	
	public int getValue(){
		return this.v;
	}
	
	
	public static RegisteredAccountState valueOf(int v){
		RegisteredAccountState[] values = RegisteredAccountState.values();
		for (RegisteredAccountState registeredAccountState : values) {
			if(v== registeredAccountState.getValue())return registeredAccountState;
		}
		
		throw new IllegalArgumentException("Unkown enum value");
	}
	
}
