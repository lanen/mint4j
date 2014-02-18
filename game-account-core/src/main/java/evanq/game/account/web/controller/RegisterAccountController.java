package evanq.game.account.web.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(RegisterAccountController.class);
	
	private static final String REGISTER_VIEW = "casAccountRegisterView"; 
	private static final String REGISTER_VIEW_SUCCESS = "casAccountRegisterSuccessView"; 
	private static final String REGISTER_VIEW_FAILED = "casAccountRegisterFailedView"; 
	private static final String SERVICE_AGREEMENT_VIEW = "serviceAgreementView";
	
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
		
		if(! form.isSeviceAgreement()){
			logger.debug("<Must Agree the Service Agreement.>");
		}
		
		if ( ! StringUtils.hasText(account)) {
			
		}
		
		if ( ! StringUtils.hasText(password)) {
			
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
		acc.setState(1);
		acc.setEmail("");
		acc.setFlag(1);
		acc.setMobile("");
		
		accountManager.save(acc);
		
		return new ModelAndView(REGISTER_VIEW_SUCCESS);
		
	}
	
	/**
	 * 
	 * 显示服务条款
	 * @return
	 */
	@RequestMapping("/serviceAgreement.html")
	public ModelAndView showServiceAgreement(){
		return new ModelAndView(SERVICE_AGREEMENT_VIEW);
	}
}
