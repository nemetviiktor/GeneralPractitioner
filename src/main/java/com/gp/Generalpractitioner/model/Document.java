package com.gp.Generalpractitioner.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document {

	@Id
	@Column(name = "document_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDocument;

	@Column(name = "title")
	private String title;

	@Column(name = "diet")
	private boolean diet;

	@Column(name = "diet_description")
	private String dietDescription;

	@Column(name = "psychiatric_disorder")
	private boolean psychiatricDisorder;

	@Column(name = "disability")
	private boolean disability;

	@Column(name = "disability_description")
	private String disabilityDescription;

	@Column(name = "infectious_disease")
	private boolean infectiousDisease;

	@Column(name = "note")
	private String note;

	@Column(name = "date")
	private Date date;

	@Column(name = "file_Name")
	private String fileName;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient socialSecurityNumber;

	public Integer getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDiet() {
		return diet;
	}

	public void setDiet(boolean diet) {
		this.diet = diet;
	}

	public String getDietDescription() {
		return dietDescription;
	}

	public void setDietDescription(String dietDescription) {
		this.dietDescription = dietDescription;
	}

	public boolean isPsychiatricDisorder() {
		return psychiatricDisorder;
	}

	public void setPsychiatricDisorder(boolean psychiatricDisorder) {
		this.psychiatricDisorder = psychiatricDisorder;
	}

	public boolean isDisability() {
		return disability;
	}

	public void setDisability(boolean disability) {
		this.disability = disability;
	}

	public String getDisabilityDescription() {
		return disabilityDescription;
	}

	public void setDisabilityDescription(String disabilityDescription) {
		this.disabilityDescription = disabilityDescription;
	}

	public boolean isInfectiousDisease() {
		return infectiousDisease;
	}

	public void setInfectiousDisease(boolean infectiousDisease) {
		this.infectiousDisease = infectiousDisease;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Patient getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(Patient socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Document(Integer idDocument, String title, boolean diet, String dietDescription, boolean psychiatricDisorder,
			boolean disability, String disabilityDescription, boolean infectiousDisease, String note, Date date,
			String fileName, Patient socialSecurityNumber) {
		this.idDocument = idDocument;
		this.title = title;
		this.diet = diet;
		this.dietDescription = dietDescription;
		this.psychiatricDisorder = psychiatricDisorder;
		this.disability = disability;
		this.disabilityDescription = disabilityDescription;
		this.infectiousDisease = infectiousDisease;
		this.note = note;
		this.date = date;
		this.fileName = fileName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Document() {
	}
}
