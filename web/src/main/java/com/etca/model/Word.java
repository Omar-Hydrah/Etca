package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import java.util.Set;
import java.util.HashSet;

@Entity
public class Word{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="level_id")
	private Level levelId;

	@Column(nullable=false)
	private String word;

	@ManyToOne
	@JoinColumn(name="language_id")
	private Language languageId; 

	public Word(){

	}


	public Word(Long id, String word, Level levelId){
		this.id      = id;
		this.word    = word;
		this.levelId = levelId;
	}

	public Word(Long id, String word, Language language){
		this.id       = id;
		this.word     = word;
		this.languageId = language;
	}

	public Word(Long id, String word, Language language, Level levelId){
		this(id, word, levelId);
		this.languageId = language;
	}

	public Word(String word, Long languageId, Long levelId){

		this.word     = word;
		this.languageId = new Language(languageId);
		this.levelId    = new Level(levelId);
	}

	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public Level getLevel() { return this.levelId; }
	public void setLevel(Level level) { this.levelId = levelId; }
	public void setLevel(Long id){this.levelId = new Level(id);}
	public String getWord() { return this.word; }
	public void setWord(String word) { this.word = word; }
	public Language getLanguage(){return this.languageId;}
	public void setLanguage(Language lang){this.languageId = lang;}
	public void setLanguage(Long id){this.languageId = new Language(id);}

	@Override
	public String toString(){
		return 
			"{" +
				"id: " + this.id + "," + 
				"word: " + this.word + ", " + 
				"languageId: " + this.languageId + ", " + 
				"levelId: " + this.levelId +
			"}";
	}
}