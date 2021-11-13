package com.gp.Generalpractitioner.controller.dto;

import java.sql.Date;

public class NewsDTO {
	
	private Date date;
	private String title;
	private String description;
	private Integer idUser;

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
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

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public NewsDTO(Date date, String title, String description, Integer idUser) {
		this.date = date;
		this.title = title;
		this.description = description;
		this.idUser = idUser;
	}

	public NewsDTO() {
	}
}
