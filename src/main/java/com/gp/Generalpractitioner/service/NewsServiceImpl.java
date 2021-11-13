package com.gp.Generalpractitioner.service;

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
	public Iterable<News> listNews() {
		return newsRepository.findAll();
	}

	@Override
	public News saveNews(NewsDTO newsDTO) {
		return newsRepository.save(new NewsUtil().convertNewsDTOtoNews(newsDTO));
	}
}
