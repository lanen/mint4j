package evanq.game.realmd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RealmController {

	@RequestMapping("/realm.jhtml")
	public ModelAndView p(){
		System.out.println("DDDDDDDDDD");
		return new ModelAndView("RealmListView");
	}
	
}
