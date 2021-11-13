package com.gp.Generalpractitioner.service;

import com.gp.Generalpractitioner.controller.dto.NewsDTO;
import com.gp.Generalpractitioner.model.News;

public interface NewsService {

	public Iterable<News> listNews();

	public News saveNews(NewsDTO newsDTO);

}
