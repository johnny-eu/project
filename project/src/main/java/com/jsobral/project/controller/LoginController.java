package com.jsobral.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String loginMessage(ModelMap model){
		model.addAttribute("message","Hello Spring User");
		return "/login";		
	}
	
}
