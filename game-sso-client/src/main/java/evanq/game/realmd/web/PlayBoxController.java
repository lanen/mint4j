package evanq.game.realmd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import evanq.game.playbox.PlayBoxView;
import evanq.game.playbox.PlayBox;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
@Controller
public class PlayBoxController {

	
	private PlayBox playBox;
	
	
	@RequestMapping(value="/playbox/{game}/{realm}/{account}.jhtml" ,method=RequestMethod.GET)
	public ModelAndView display(@PathVariable("game") int gameId,@PathVariable("realm") int realm,@PathVariable("realm") String account){
		
		ModelAndView model = new ModelAndView("PlayBoxView");
		
		model.addObject("game", gameId);
		model.addObject("realm", realm);
		model.addObject("gate_type","socket");
		model.addObject("game_version","127.0.0.1:8123");
		model.addObject("playbox_version","127.0.0.1:8123");
		model.addObject("copyright","127.0.0.1:8123");
		model.addObject("about","127.0.0.1:8123");
		model.addObject("gate","127.0.0.1:8123");
		
		return model;
	}
		
}
