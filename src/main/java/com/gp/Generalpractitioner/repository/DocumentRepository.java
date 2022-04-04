package com.gp.Generalpractitioner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gp.Generalpractitioner.model.Document;
import com.gp.Generalpractitioner.model.Patient;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Integer>{
	
	public List<Document> findBySocialSecurityNumber(Patient socialSecurityNumber);
	
	public void deleteBySocialSecurityNumber(Patient socialSecurityNumber);
}
