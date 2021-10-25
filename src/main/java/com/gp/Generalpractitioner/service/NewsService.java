package com.gp.Generalpractitioner.service;

import java.util.List;

import com.gp.Generalpractitioner.controller.dto.NewsDTO;
import com.gp.Generalpractitioner.model.News;


public interface NewsService {

	public List<News> listNews();
	
	public News saveNews(NewsDTO newsDTO);
	
}
