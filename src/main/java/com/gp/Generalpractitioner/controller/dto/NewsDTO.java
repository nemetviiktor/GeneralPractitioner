package com.gp.Generalpractitioner.controller.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewsDTO {
	
	private Date date;
	
	@NotEmpty(message = "Kérem adja meg a címet!")
	private String title;
	
	@NotEmpty(message = "Kérem adja meg a leírást!")
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

	public NewsDTO(Date date, @NotEmpty(message = "Kérem adja meg a címet!") String title,
			@NotEmpty(message = "Kérem adja meg a leírást!") String description, Integer idUser) {
		super();
		this.date = date;
		this.title = title;
		this.description = description;
		this.idUser = idUser;
	}

	public NewsDTO() {
	}
}
