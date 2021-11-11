package com.gp.Generalpractitioner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gp.Generalpractitioner.service.NewsService;

@Controller
public class IndexController {

	private NewsService newsService;

	@Autowired
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Index(Model model) {
		model.addAttribute("news", newsService.listNews());
		return "index";
	}

	@RequestMapping("/login")
	public String login() {

		return "login";
	}
}
