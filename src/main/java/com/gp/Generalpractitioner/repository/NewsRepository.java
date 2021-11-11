package com.gp.Generalpractitioner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gp.Generalpractitioner.model.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer> {	
}

