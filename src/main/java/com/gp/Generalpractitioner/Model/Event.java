package com.gp.Generalpractitioner.Model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="event")
public class Event {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	
	@Column(name="taj")
	private String taj;
	
	@Column(name="name")
	private String name;
	
    
	@Column(name="date")
	private Date date;
	
	@Column(name="counter")
	private int counter;
	
	@Column(name="time")
	private String time;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTaj() {
		return taj;
	}

	public void setTaj(String taj) {
		this.taj = taj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Event [Id=" + Id + ", taj=" + taj + ", name=" + name + ", date=" + date + ", counter=" + counter
				+ ", time=" + time + "]";
	}
}
