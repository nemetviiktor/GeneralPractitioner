package com.gp.Generalpractitioner.controller;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gp.Generalpractitioner.controller.dto.NewsDTO;
import com.gp.Generalpractitioner.service.NewsService;

@Controller
public class NewsController {
	
	private NewsService newsService;
	
	@Autowired
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	@RequestMapping(value = "/admin")
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminPosts");
		mav.addObject("newsDTO", new NewsDTO());
		return mav;
	}
	
	@PostMapping("/newPost")
	public ModelAndView newPost(@ModelAttribute("newsDTO") NewsDTO newsDTO) {
		Date date = new Date();                                                      //.toString()
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.");
		String today = sdf.format(date);
		newsDTO.setDate(today);
		
		newsService.saveNews(newsDTO);
		return new ModelAndView("redirect:/");
	}

}

/*
@PostMapping("/addmessage")
	public ModelAndView addMessage(@Valid @ModelAttribute("messageDTO") MessageDTO messageDTO, BindingResult bindingResult){
		
		if (!bindingResult.hasErrors()) {
			String date = new Date().toString();
			messageDTO.setDate(date);
			messageService.saveMessage(messageDTO);
			return new ModelAndView("redirect:/");
		}
		
		User user = userService.findById(messageDTO.getToid()).orElse(new User());
		return new ModelAndView("sendmessage").addObject(user).addObject("messageDTO", messageDTO);
*/