package com.gp.Generalpractitioner.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@Column(name = "appointment_id")
	private Integer idAppointment;

	@Column(name = "date")
	private Date date;

	@Column(name = "time_index")
	private int index;

	@Column(name = "time")
	private String time;

	@Column(name = "medical_examination")
	private String medicalExamination;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient socialSecurityNumber;

	public Integer getIdAppointment() {
		return idAppointment;
	}

	public void setIdAppointment(Integer idAppointment) {
		this.idAppointment = idAppointment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMedicalExamination() {
		return medicalExamination;
	}

	public void setMedicalExamination(String medicalExamination) {
		this.medicalExamination = medicalExamination;
	}

	public Patient getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(Patient socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Appointment(Integer idAppointment, Date date, int index, String time, String medicalExamination,
			Patient socialSecurityNumber) {
		this.idAppointment = idAppointment;
		this.date = date;
		this.index = index;
		this.time = time;
		this.medicalExamination = medicalExamination;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Appointment() {
	}
}
