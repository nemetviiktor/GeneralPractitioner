package com.gp.Generalpractitioner.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderinghours")
public class OrderingHours {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="day")
	private String day;
	
	@Column(name="start")
	private String start;
	
	@Column(name="end")
	private String end;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "OrderingHours [Id=" + Id + ", day=" + day + ", start=" + start + ", end=" + end + "]";
	}
	
	

}
