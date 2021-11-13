package com.gp.Generalpractitioner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gp.Generalpractitioner.model.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer> {
}
