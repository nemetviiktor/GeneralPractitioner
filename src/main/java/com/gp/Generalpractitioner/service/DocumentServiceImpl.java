package com.gp.Generalpractitioner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.Generalpractitioner.controller.dto.DocumentDTO;
import com.gp.Generalpractitioner.model.Document;
import com.gp.Generalpractitioner.model.Patient;
import com.gp.Generalpractitioner.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	private DocumentRepository documentRepository;

	@Autowired
	public void setDocumentRepository(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}

	@Override
	public Iterable<Document> listDocuments() {
		return documentRepository.findAll();
	}

	@Override
	public Document saveDocument(DocumentDTO documentDTO) {
		return documentRepository.save(new DocumentUtil().convertDocumentDTOtoDocument(documentDTO));
	}

	@Override
	public List<Document> findDocumentsBySocialSecurityNumber(Patient socialSecurityNumber) {
		List<Document> documents = new ArrayList<Document>();
		documents.addAll(documentRepository.findBySocialSecurityNumber(socialSecurityNumber));
		return documents;
	}

	@Override
	public void deleteDocument(Patient socialSecurityNumber) {
		documentRepository.deleteBySocialSecurityNumber(socialSecurityNumber);
	}
}
