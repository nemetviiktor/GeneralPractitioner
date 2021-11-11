package com.gp.Generalpractitioner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document {

	@Id
	@Column(name="iddocument")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDocument;

	public Integer getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}

	public Document(Integer idDocument) {
		this.idDocument = idDocument;
	}

	public Document() {
	}
	
	

}
