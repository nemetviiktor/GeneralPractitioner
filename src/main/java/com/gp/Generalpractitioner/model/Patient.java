package com.gp.Generalpractitioner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
    @Column(name = "patient_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPatient; 
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="social_security_number")
	private String socialSecurityNumber;
	
	@Column(name="fk_appointment_id")
	private Integer idAppointment;

	public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
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

	@Override
	public String toString() {
		return "Patient [idPatient=" + idPatient + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", socialSecurityNumber=" + socialSecurityNumber + ", idAppointment=" + idAppointment + "]";
	}
	
}
