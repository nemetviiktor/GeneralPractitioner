package com.gp.Generalpractitioner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class News {
	
	@Id
	@Column(name="idnews")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idnews;
	
	@Column(name="date")
	private String date;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;

	public Integer getIdnews() {
		return idnews;
	}

	public void setIdnews(Integer idnews) {
		this.idnews = idnews;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "News [idnews=" + idnews + ", date=" + date + ", title=" + title + ", description=" + description + "]";
	}
}
