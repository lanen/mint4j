package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {
 
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView  printHello() {
		return new ModelAndView("hello", "message", "Hello Spring Security !");
	}
}