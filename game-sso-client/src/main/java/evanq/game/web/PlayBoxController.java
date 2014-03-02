package evanq.game.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import evanq.game.playbox.PlayBox;
import evanq.game.realmd.Realm;
import evanq.game.realmd.RealmRegistry;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
@Controller
public class PlayBoxController {

	@Autowired
	@Qualifier("realmRegistry")
	private RealmRegistry realmRegistry;
	
	
	@RequestMapping(value="/playbox" ,method=RequestMethod.GET)	
	public ModelAndView display(HttpServletRequest request){
		
		
		//根据账号的记录，获取账号的分区。
		//列出所有分区。
		//展示进入按钮。
		
		ModelAndView model = new ModelAndView("PlayBoxView");
		return model;
	}
	
	@RequestMapping(value="/playbox/{game}/{realm}" ,method=RequestMethod.GET)
	public ModelAndView display(@PathVariable("game") int gameId,@PathVariable("realm") int realmId,HttpServletRequest request){
		
		
		String name = request.getUserPrincipal().getName();
		if(null == 	name){
			System.out.println("账号 null");
		}
		
		Realm realm = realmRegistry.findBy(realmId);
		
		ModelAndView model = new ModelAndView("PlayBoxView");
		model.addObject("account",name);
		
		model.addObject("playbox_version","127.0.0.1:8123");
		model.addObject("game", gameId);
		model.addObject("realm", realm);
		model.addObject("gate_type","socket");
		model.addObject("copyright","127.0.0.1:8123");
		model.addObject("about","127.0.0.1:8123");
		
		return model;
	}
		
}
