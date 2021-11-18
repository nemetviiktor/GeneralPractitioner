package com.gp.Generalpractitioner.controller.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;


public class PatientDTO {
	
	@NotEmpty(message = "Kérem adja meg a vezetéknevét!")
	@Size(max = 25, message = "Legfeljebb 25 karakter hosszú lehet.")
	private String lastName;
	
	@NotEmpty(message = "Kérem adja meg a keresztnevét!")
	@Size(max = 25, message = "Legfeljebb 25 karakter hosszú lehet.")
	private String firstName;
	
	//@NotNull(message = "Kérem adja meg a TAJ számát!")
	@Pattern(regexp="[\\d]{9}", message = "Kérem adja meg a 9 számjegyből álló TAJ számát!")
	private String socialSecurityNumber;
	
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

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Integer getIdAppointment() {
		return idAppointment;
	}

	public void setIdAppointment(Integer idAppointment) {
		this.idAppointment = idAppointment;
	}

	public PatientDTO(
			@NotEmpty(message = "Kérem adja meg a vezetéknevét!") @Size(max = 25, message = "Legfeljebb 25 karakter hosszú lehet.") String lastName,
			@NotEmpty(message = "Kérem adja meg a keresztnevét!") @Size(max = 25, message = "Legfeljebb 25 karakter hosszú lehet.") String firstName,
			@Pattern(regexp = "[\\d]{9}", message = "Kérem adja meg a 9 számjegyből álló TAJ számát!") String socialSecurityNumber,
			Integer idAppointment) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.idAppointment = idAppointment;
	}

	public PatientDTO() {
		super();
	}

	
	
	
}
