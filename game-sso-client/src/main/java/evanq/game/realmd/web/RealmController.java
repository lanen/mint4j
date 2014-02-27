package evanq.game.realmd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import evanq.game.realmd.RealmRegistry;


@Controller
public class RealmController {

	@Autowired
	private RealmRegistry realmRegistry;
	
	@RequestMapping("/realm.jhtml")
	public ModelAndView p(){
		System.out.println("DDDDDDDDDD");
		
		
		return new ModelAndView("RealmListView");
	}
	
}
