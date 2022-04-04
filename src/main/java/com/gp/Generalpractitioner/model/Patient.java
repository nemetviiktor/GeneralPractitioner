package com.gp.Generalpractitioner.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@Column(name = "patient_id")
	private String socialSecurityNumber;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "phone_number")
	private String phoneNumber;

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

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

	public Patient(String socialSecurityNumber, String lastName, String firstName, Date dateOfBirth,
			String phoneNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
	}

	public Patient() {
	}
}
