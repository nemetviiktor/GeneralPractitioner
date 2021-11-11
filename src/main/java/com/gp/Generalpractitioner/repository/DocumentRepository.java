package com.gp.Generalpractitioner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gp.Generalpractitioner.model.Document;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Integer>{

}
