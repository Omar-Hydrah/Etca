package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;


@Entity
public class Level{
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=true)
	private String title;

	@ManyToOne
	@JoinColumn(name="language")
	private Language language;

	public Level(){

	}

	public Level(String title, Language language){
		this.title = title; 
		this.language = language;
	}

	public Level(Long id, String title, Language language){
		this.id = id;
		this.title = title;
		this.language = language;
	}

	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	public Language getLanguage(){return this.language;}
	public void setLanguage(Language language){this.language = language;}
}