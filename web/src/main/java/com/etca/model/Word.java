package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import java.util.Set;
import java.util.HashSet;

@Entity
public class Word{
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name="level_id")
	private Level levelId;

	@Column(nullable=false)
	private String word;

	@ManyToOne
	@JoinColumn(name="language")
	private Language language; 

	public Word(){

	}

	public Word(Long id, Level levelId, String word){
		this.id = id;
		this.levelId = levelId;
		this.word    = word;
	}

	public Word(Long id, Level levelId, String word, Language language){
		this(id, levelId, word);
		this.language = language;	
	}

	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public Level getLevelId() { return this.levelId; }
	public void setLevelId(Level levelId) { this.levelId = levelId; }
	public String getWord() { return this.word; }
	public void setWord(String word) { this.word = word; }
	public Language getLanguage(){return this.language;}
	public void setLanguage(String lang){this.language = language;}
}