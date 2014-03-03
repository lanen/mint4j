package evanq.game.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import evanq.game.playbox.PlayBox;
import evanq.game.realmd.RealmRegistry;

/**
 * 
 * 游戏信息
 * 
 * <pre>
 * 在门户进入游戏的资源设计
 * /game/{id} - 通过游戏ID 访问
 * /game/{shortName} 通过游戏缩写访问
 * 
 * 进到具体游戏分区的资源设计
 * /reaml/{id} 游戏分区
 * /playbox/{id} 游戏盒，包转指定分区 {需要账号验证}
 * 
 * 在游戏盒访问了cas之后，其他分区不需要访问
 * </pre>
 * 
 * @author Evan cppmain@gmail.com
 *
 */
@Controller
public class GameController {

	
	private static final String GAMEINFO_VIEW = "GameInfoView";
	
	/**
	 * 游戏分区注册表
	 */
	private RealmRegistry realmRegistry;
	
	
	/**
	 * 游戏盒 
	 */
	private PlayBox playBox;
		
	
	@RequestMapping(value="/game/{id}",method=RequestMethod.GET)
	public ModelAndView gameInfoView(@PathVariable("id")int id){
		System.out.println("GameController.gameInfoView(id)");
		return new ModelAndView(GAMEINFO_VIEW);
	}

	@RequestMapping(value="/g/{shortName}",method=RequestMethod.GET)
	public ModelAndView gameInfoView2(@PathVariable("shortName")String shortName){
		System.out.println("GameController.gameInfoView(shortName)");
		
		return new ModelAndView(GAMEINFO_VIEW);
	}
	
	
	
}
