package com.gp.Generalpractitioner.controller.dto;

import java.sql.Date;

public class AppointmentDTO {
	
	private Integer idAppointment;
	private Date date;
	private String time;
	private Integer index;
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



	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}



	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	


	public AppointmentDTO(Integer idAppointment, Date date, String time, Integer index, String socialSecurityNumber) {
		super();
		this.idAppointment = idAppointment;
		this.date = date;
		this.time = time;
		this.index = index;
		this.socialSecurityNumber = socialSecurityNumber;
	}



	public AppointmentDTO() {
	}
}
