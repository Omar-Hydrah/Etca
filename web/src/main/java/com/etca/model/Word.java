package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
public class Word{
	@Id
	@GeneratedValue
	private Long id;

	private Long levelId;

	private String word;

	public Word(Long id, Long levelId, String word){
		this.id = id;
		this.levelId = levelId;
		this.word    = word;
	}

	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public Long getLevelId() { return this.levelId; }
	public void setLevelId(Long levelId) { this.levelId = levelId; }
	public String getWord() { return this.word; }
	public void setWord(String word) { this.word = word; }
}