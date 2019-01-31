package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
	name="word_translation",
	uniqueConstraints=@UniqueConstraint(columnNames={"word_id", "translation_id"})
)
public class WordTranslation{

	@Id @GeneratedValue
	private Long id;

	@Column(name="word_id")
	private Long wordId;

	@Column(name="translation_id")
	private Long translationId;

	@Column
	private String wordLanguage;

	@Column
	private String translationLanguage;

	public WordTranslation(){
		
	}

	public WordTranslation(Long wordId, Long translationId, 
		String wordLanguage, String translationLanguage)
	{
		this.wordId = wordId;
		this.translationId = translationId;
		this.wordLanguage  = wordLanguage;
		this.translationLanguage = translationLanguage;
	}


	public Long getWordId() { return this.wordId; }
	public void setWordId(Long wordId) { this.wordId = wordId; }
	public Long getTranslationId() { return this.translationId; }
	public void setTranslationId(Long translationId) { this.translationId = translationId; }
	public String getWordLanguage() { return this.wordLanguage; }
	public void setWordLanguage(String wordLanguage) { this.wordLanguage = wordLanguage; }
	public String getTranslationLanguage() { return this.translationLanguage; }
	public void setTranslationLanguage(String translationLanguage) { 
		this.translationLanguage = translationLanguage; 
	}
}