package com.gp.Generalpractitioner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.Generalpractitioner.controller.dto.NewsDTO;
import com.gp.Generalpractitioner.model.News;
import com.gp.Generalpractitioner.repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {

	private NewsRepository newsRepository;
	
	@Autowired
	public NewsServiceImpl(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

	@Override
	public List<News> listNews() {
		return newsRepository.findAll();
	}


	@Override
	public News saveNews(NewsDTO newsDTO) {
		return newsRepository.save(convertNewsDTOtoNews(newsDTO));
	}
	
	private News convertNewsDTOtoNews(NewsDTO newsDTO) {
		News news = new News();
		news.setDate(newsDTO.getDate());
		news.setTitle(newsDTO.getTitle());
		news.setDescription(newsDTO.getDescription());
		return news;
	}
}
