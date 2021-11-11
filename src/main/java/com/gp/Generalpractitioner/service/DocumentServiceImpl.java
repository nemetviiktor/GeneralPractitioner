package com.gp.Generalpractitioner.service;

import org.springframework.stereotype.Service;

import com.gp.Generalpractitioner.model.Document;
import com.gp.Generalpractitioner.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	private DocumentRepository documentRepository;

	public void setDocumentRepository(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}


	@Override
	public Iterable<Document> listDocuments() {
		return documentRepository.findAll();
	}

}
