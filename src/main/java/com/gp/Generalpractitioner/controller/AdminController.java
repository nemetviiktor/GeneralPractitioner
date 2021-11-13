package com.gp.Generalpractitioner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/login")
	public String login() {

		return "login";
	}
	
	@RequestMapping("/error/403")
	public String admin() {
		
		return "login";
	}
}
