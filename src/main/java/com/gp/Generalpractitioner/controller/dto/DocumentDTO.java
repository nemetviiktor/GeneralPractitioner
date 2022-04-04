package com.gp.Generalpractitioner.controller.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

public class DocumentDTO {

	private Integer idDocument;

	@NotEmpty(message = "Kérem, adja meg a dokumentum címét!")
	private String title;

	private boolean diet;
	private String dietDescription;
	private boolean psychiatricDisorder;
	private boolean disability;
	private String disabilityDescription;
	private boolean infectiousDisease;
	private String note;
	private String socialSecurityNumber;
	private Date date;
	private String fileName;

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

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
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

	public DocumentDTO(Integer idDocument, @NotEmpty(message = "Kérem, adja meg a dokumentum címét!") String title,
			boolean diet, String dietDescription, boolean psychiatricDisorder, boolean disability,
			String disabilityDescription, boolean infectiousDisease, String note, String socialSecurityNumber,
			Date date, String fileName) {
		super();
		this.idDocument = idDocument;
		this.title = title;
		this.diet = diet;
		this.dietDescription = dietDescription;
		this.psychiatricDisorder = psychiatricDisorder;
		this.disability = disability;
		this.disabilityDescription = disabilityDescription;
		this.infectiousDisease = infectiousDisease;
		this.note = note;
		this.socialSecurityNumber = socialSecurityNumber;
		this.date = date;
		this.fileName = fileName;
	}

	public DocumentDTO() {
	}

}
