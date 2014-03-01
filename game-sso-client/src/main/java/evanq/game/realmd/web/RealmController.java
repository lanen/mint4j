package evanq.game.realmd.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import evanq.game.realmd.Realm;
import evanq.game.realmd.RealmRegistry;


/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
@Controller
public class RealmController {

	private Logger logger = LoggerFactory.getLogger(RealmController.class);
	
	@Autowired
	@Qualifier("realmRegistry")
	private RealmRegistry realmRegistry;
	
	@RequestMapping("/realm")
	public ModelAndView accessRealmList(){
	
		logger.debug("RealmController.accessRealmList()");
		
		
		//TODO 在切面上做判断。
		if(null == realmRegistry){
			throw new IllegalStateException("realmRegistry is null");
		}
		
		List<Realm> load = realmRegistry.load();
		
		return new ModelAndView("RealmListView","realms",load);
	}
	
		
	@RequestMapping(value="/realm/{id}" ,method=RequestMethod.GET)
	public ModelAndView accessRealm(@PathVariable int id){

		// 读取账户
		
		//
		
		
		return new ModelAndView("RealmView","realm_detail","ss");
	}
	
	
	//TODO 这种类型的操作，要求在切面上做安全验证。只有管理员才可以做
	@RequestMapping(value="/realm/{id}" ,method=RequestMethod.PUT)
	public ModelAndView updateRealm(@PathVariable int id,HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("RealmView","realm_update","ss");
	}
	
	
	@RequestMapping(value="/realm/{id}/status" ,method=RequestMethod.GET)
	public ModelAndView accessRealmStatus(@PathVariable int id){
	
		//
		
		
		return new ModelAndView("RealmView","realm_detail","ss");
	}
	
}