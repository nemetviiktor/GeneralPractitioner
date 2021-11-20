package com.gp.Generalpractitioner.service;

import com.gp.Generalpractitioner.controller.dto.NewsDTO;
import com.gp.Generalpractitioner.model.News;
import com.gp.Generalpractitioner.model.User;

public class NewsUtil {
	
	public News convertNewsDTOtoNews(NewsDTO newsDTO) {
		News news = new News();
		news.setDate(newsDTO.getDate());
		news.setTitle(newsDTO.getTitle());
		news.setDescription(newsDTO.getDescription());
		User user = new User();
		user.setId(newsDTO.getIdUser());
		news.setIdUser(user);
		return news;
	}

}
