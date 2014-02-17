package evanq.game.account.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import evanq.game.account.Account;
import evanq.game.account.AccountManager;
import evanq.game.account.RegisteredAccount;
import evanq.game.account.RegisteredAccountImpl;
import evanq.game.account.web.form.RegisterAccountForm;

/**
 * 展示注册表单
 * 
 * @author Evan cppmain@gmail.com
 *
 */


@Controller("registerAccountController")
public class RegisterAccountController   {
	
	private static final String REGISTER_VIEW = "default/ui/casAccountRegisterView"; 
	private static final String REGISTER_VIEW_SUCCESS = "default/ui/casAccountRegisterSuccessView"; 
	private static final String REGISTER_VIEW_FAILED = "default/ui/casAccountRegisterFailedView"; 
	
	@Autowired
	private AccountManager accountManager;
	
	@RequestMapping("/reg.html")
	public ModelAndView registerPage(){
		return new ModelAndView(REGISTER_VIEW,"reg",new RegisterAccountForm());
	}
	
	@RequestMapping( value={"/postReg.html"}, method = RequestMethod.POST)	
	public ModelAndView postRegister(@ModelAttribute("reg") RegisterAccountForm form,BindingResult result){
		

		String account = form.getAccount();
		String password = form.getPassword();
		String passwordConfirmed = form.getPasswordConfirmed();
		
		
		if ( ! StringUtils.hasText(account)) {
			
		}
		
		if ( ! StringUtils.hasText(password)) {
			
		}
		
		if ( ! StringUtils.hasText(passwordConfirmed)) {
			
		}
		
		//step 1. 账号是否存在
		RegisteredAccount findAccountBy = accountManager.findAccountBy(form);
		if(null != findAccountBy){
			
			return new ModelAndView(REGISTER_VIEW_FAILED,"message","账号存在");
		}
		//step 2. 密码安全检查
		//step 3. Email 检查
		RegisteredAccountImpl acc = new RegisteredAccountImpl();
		acc.setAccount(account);
		acc.setPasswd(password);
		
		accountManager.save(acc);
		
		return new ModelAndView(REGISTER_VIEW_SUCCESS);
	}
}
