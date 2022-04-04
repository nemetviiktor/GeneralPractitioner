package com.gp.Generalpractitioner.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gp.Generalpractitioner.controller.dto.NewsDTO;
import com.gp.Generalpractitioner.security.UserDetailsImpl;
import com.gp.Generalpractitioner.service.DateUtil;
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
	public ModelAndView newPost(@Valid @ModelAttribute("newsDTO") NewsDTO newsDTO, BindingResult bindingResult,
			@AuthenticationPrincipal UserDetailsImpl user) {
		
		if (!bindingResult.hasErrors()) {
			newsDTO.setIdUser(user.getId());
			newsDTO.setDate(new DateUtil().getCurrentDate());
			newsService.saveNews(newsDTO);
			return new ModelAndView("redirect:/admin");
		}
		return new ModelAndView("adminPosts").addObject("newsDTO", newsDTO);
	}
}