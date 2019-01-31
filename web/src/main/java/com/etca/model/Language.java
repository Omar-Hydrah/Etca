package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class Language{

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private LanguageEnum language;

	public Language(){
		
	}

	public Language(LanguageEnum language){
		this.language = language;
	}

	public Language(Long id, LanguageEnum language){
		this.id = id;
		this.language = language;
	}

	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public LanguageEnum getLanguage() { return this.language; }
	public void setLanguage(LanguageEnum language) { this.language = language; }
}