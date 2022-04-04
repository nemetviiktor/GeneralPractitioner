package com.gp.Generalpractitioner.controller.dto;

import java.sql.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class PatientDTO {

	@Pattern(regexp = "[\\d]{9}", message = "Kérem, adja meg a 9 számjegyből álló TAJ számát!")
	private String socialSecurityNumber;
	
	@NotEmpty(message = "Kérem, adja meg a vezetéknevét!")
	@Size(max = 25, message = "Legfeljebb 25 karakter hosszú lehet.")
	private String lastName;

	@NotEmpty(message = "Kérem, adja meg a keresztnevét!")
	@Size(max = 25, message = "Legfeljebb 25 karakter hosszú lehet.")
	private String firstName;

	@AssertTrue(message = "Kérem, fogadja el az adatvédelmi nyilatkozatot!")
	private boolean agreeGDPR;

	@NotNull
	private Date dateOfBirth;

	@Pattern(regexp = "\\d{2}\\-\\d{2}\\/\\d{4}\\-\\d{3}", message ="Kérem, a példa mintájára, helyesen adja meg a telefonszámát!")
	private String phoneNumber;

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

	public boolean isAgreeGDPR() {
		return agreeGDPR;
	}

	public void setAgreeGDPR(boolean agreeGDPR) {
		this.agreeGDPR = agreeGDPR;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PatientDTO(
			@NotEmpty(message = "Kérem, adja meg a vezetéknevét!") @Size(max = 25, message = "Legfeljebb 25 karakter hosszú lehet.") String lastName,
			@NotEmpty(message = "Kérem, adja meg a keresztnevét!") @Size(max = 25, message = "Legfeljebb 25 karakter hosszú lehet.") String firstName,
			@Pattern(regexp = "[\\d]{9}", message = "Kérem, adja meg a 9 számjegyből álló TAJ számát!") String socialSecurityNumber,
			@AssertTrue(message = "Kérem, fogadja el az adatvédelmi nyilatkozatot!") boolean agreeGDPR,
			@NotNull Date dateOfBirth,
			@Pattern(regexp = "\\d{2}\\-\\d{2}\\/\\d{4}\\-\\d{3}", message = "Kérem, a példa mintájára, helyesen adja meg a telefonszámát!") String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.agreeGDPR = agreeGDPR;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
	}

	public PatientDTO() {
	}
}
