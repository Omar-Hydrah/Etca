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
	@Enumerated(EnumType.STRING)
	private LanguageEnum language;

	public Language(){
		
	}

	public Language(LanguageEnum languageEnum){
		this.language = languageEnum;
	}

	public Language(Long id, LanguageEnum languageEnum){
		this.id = id;
		this.language = languageEnum;
	}

	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public LanguageEnum getLanguageEnum() { return this.language; }
	public void setLanguageEnum(LanguageEnum langEnum) { 
		this.language = langEnum;}

	public String getLanguage(){return this.language.getLanguage();}
}