package com.gp.Generalpractitioner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gp.Generalpractitioner.model.User;
import com.gp.Generalpractitioner.repository.UserRepository;
import com.gp.Generalpractitioner.service.NewsService;

@Controller
public class IndexController {
	
	
private NewsService newsService;
	
	@Autowired
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	
	
	// DTO-VAL KELLENE ÁTADNI ÉS AKKOR A DÁTUM MAGYAR LENNE
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String Index(Model model) {
		model.addAttribute("news", newsService.listNews());
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	
}
