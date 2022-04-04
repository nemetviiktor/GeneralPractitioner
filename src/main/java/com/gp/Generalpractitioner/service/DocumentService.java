package com.gp.Generalpractitioner.service;

import java.util.List;

import com.gp.Generalpractitioner.controller.dto.DocumentDTO;
import com.gp.Generalpractitioner.model.Document;
import com.gp.Generalpractitioner.model.Patient;

public interface DocumentService {
	
	public Iterable<Document> listDocuments();
	
	public Document saveDocument(DocumentDTO documentDTO);
	
	public List<Document> findDocumentsBySocialSecurityNumber(Patient socialSecurityNumber);
	
	public void deleteDocument(Patient socialSecurityNumber);

}
