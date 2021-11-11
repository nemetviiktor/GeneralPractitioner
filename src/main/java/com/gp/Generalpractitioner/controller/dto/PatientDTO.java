package com.gp.Generalpractitioner.controller.dto;

public class PatientDTO {
	
	private String lastName;
	private String firstName;
	private Integer socialSecurityNumber;
	private Integer idAppointment;
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(Integer socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Integer getIdAppointment() {
		return idAppointment;
	}

	public void setIdAppointment(Integer idAppointment) {
		this.idAppointment = idAppointment;
	}

	public PatientDTO(String lastName, String firstName, Integer socialSecurityNumber, Integer idAppointment) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.idAppointment = idAppointment;
	}

	public PatientDTO() {
	}
}
