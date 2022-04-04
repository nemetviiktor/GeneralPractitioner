package com.gp.Generalpractitioner.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class News {

	@Id
	@Column(name = "news_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNews;

	@Column(name = "date")
	private Date date;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User idUser;

	public Integer getIdnews() {
		return idNews;
	}

	public Integer getIdNews() {
		return idNews;
	}

	public void setIdNews(Integer idNews) {
		this.idNews = idNews;
	}

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

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public News(Integer idNews, Date date, String title, String description, User idUser) {
		this.idNews = idNews;
		this.date = date;
		this.title = title;
		this.description = description;
		this.idUser = idUser;
	}

	public News() {
	}

}
