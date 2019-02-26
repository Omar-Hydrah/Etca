package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@Entity
public class Language{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(unique=true, nullable=false)
	private String language;

	public Language(){
		
	}

	public Language(Long id){
		this.id = id;
	}

	public Language(String language){
		this.language = language;
	}

	public Language(Long id, String language){
		this.id = id;
		this.language = language;
	}

	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public String getLanguage(){return this.language;}
	public void setLanguage(String language) { 
		this.language = language; 
	}

}