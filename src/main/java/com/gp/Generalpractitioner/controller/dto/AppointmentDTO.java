package com.gp.Generalpractitioner.controller.dto;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class AppointmentDTO {
	
	//@Size(min = 5)
	
	private String last_name;
	
	private String first_name;
	
	private String taj;
	
	private String date;
	
	private String time;
	
	private Integer counter;

	

	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getTaj() {
		return taj;
	}



	public void setTaj(String taj) {
		this.taj = taj;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
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



	public AppointmentDTO(String last_name, String first_name, String taj, String date, String time, Integer counter) {
		super();
		this.last_name = last_name;
		this.first_name = first_name;
		this.taj = taj;
		this.date = date;
		this.time = time;
		this.counter = counter;
	}



	public AppointmentDTO() {
		super();
	}

}
