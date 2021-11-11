package com.gp.Generalpractitioner.controller.dto;

import java.sql.Date;

public class AppointmentDTO {
	
	//@Size(min = 5)
	
	private Integer idAppointment;
	private Date date;
	private String time;
	private Integer counter;
	
	public Integer getId() {
		return idAppointment;
	}
	
	public void setId(Integer idAppointment) {
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
	
	public Integer getCounter() {
		return counter;
	}
	
	public void setCounter(Integer counter) {
		this.counter = counter;
	}
	
	public AppointmentDTO(Integer idAppointment, Date date, String time, Integer counter) {
		super();
		this.idAppointment = idAppointment;
		this.date = date;
		this.time = time;
		this.counter = counter;
	}
	
	public AppointmentDTO() {
	}
}
