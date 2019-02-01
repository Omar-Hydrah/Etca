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

	public Level(){

	}

	public Level(String title, Language language){
		this.title = title; 
		this.language = language;
	}

	public Level(Long id, String title){
		this.id = id;
		this.title = title;
	}

	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
}