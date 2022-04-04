package com.gp.Generalpractitioner.controller.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AppointmentDTO {

	private Integer idAppointment;

	private Date date;

	private String time;

	private Integer index;

	@NotEmpty(message = "Kérem, adja meg a vizsgálatot!")
	@Size(max = 25, message = "Legfeljebb 45 karakter hosszú lehet.")
	private String medicalExamination;

	private String socialSecurityNumber;

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getMedicalExamination() {
		return medicalExamination;
	}

	public void setMedicalExamination(String medicalExamination) {
		this.medicalExamination = medicalExamination;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public AppointmentDTO(Integer idAppointment, Date date, String time, Integer index,
			@NotEmpty(message = "Kérem, adja meg a vizsgálatot!") @Size(max = 25, message = "Legfeljebb 45 karakter hosszú lehet.") String medicalExamination,
			String socialSecurityNumber) {
		this.idAppointment = idAppointment;
		this.date = date;
		this.time = time;
		this.index = index;
		this.medicalExamination = medicalExamination;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public AppointmentDTO() {
	}
}
