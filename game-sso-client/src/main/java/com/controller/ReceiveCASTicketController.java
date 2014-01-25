package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("j_spring_cas_security_check")
public class ReceiveCASTicketController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView  receiveTicket(String ticket) {
		System.out.println(ticket);
		return new ModelAndView("receive", "message", "Hello Spring Security !");
	}
}
