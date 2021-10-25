package com.gp.Generalpractitioner.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="taj")
	private String taj;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="counter")
	private int counter;
	
	@Column(name="time")
	private String time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", last_name=" + last_name + ", first_name=" + first_name + ", taj=" + taj
				+ ", date=" + date + ", counter=" + counter + ", time=" + time + "]";
	}


}
