package com.gp.Generalpractitioner.controller;

import java.text.ParseException;

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
	public String Index(Model model) throws ParseException {
		model.addAttribute("news", newsService.listNews());
		return "index";
	}
	
	@RequestMapping(value = "/privacyNotice", method = RequestMethod.GET)
	public String privacyNotice() {
		return "privacyNotice";
	}
	
	@RequestMapping(value = "/surgery", method = RequestMethod.GET)
	public String surgery() {
		return "surgery";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}
}
