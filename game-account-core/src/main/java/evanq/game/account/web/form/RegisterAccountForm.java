package evanq.game.account.web.form;

import evanq.game.account.Account;

/**
 * 
 * hold the register request form data
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RegisterAccountForm implements Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5203579840805100208L;

	private long id;
	
	//表单状态
	//input valid
	//valid code error
	//input required
	private String formState;
	
	private String account;
	
	private String password;
	
	/**
	 * 
	 * 注册成功重定向到地址
	 */
	private String customSuccessUrl;
	
	/**
	 * 
	 * 注册成功，产生一个票据，附带注册步骤，以及账号信息
	 */
	private String registerSuccessTicket;
	
	//服务协议
	private boolean seviceAgreement;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean getSeviceAgreement() {
		return seviceAgreement;
	}
	
	public void setSeviceAgreement(boolean seviceAgreement) {
		this.seviceAgreement = seviceAgreement;
	}
	
	public String getCustomSuccessUrl() {
		return customSuccessUrl;
	}
	
	public void setCustomSuccessUrl(String customSuccessUrl) {
		this.customSuccessUrl = customSuccessUrl;
	}
	@Override
	public boolean matches(Account account) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
