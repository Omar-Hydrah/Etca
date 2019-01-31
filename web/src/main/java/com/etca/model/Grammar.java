package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Entity
public class Grammar{

	@Id
	@GeneratedValue
	private Long id;

	private Long levelId;

	private String title;

	private String content;

	@ManyToOne
	private Language language;

	public Grammar(Long id, Long levelId, String title, String content){
		this.id      = id;
		this.levelId = levelId;
		this.title   = title;
		this.content = content;
	}

	public Grammar(String title, String content){
		this.title   = title;
		this.content = content;
	}

	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public Long getLevelId() { return this.levelId; }
	public void setLevelId(Long levelId) { this.levelId = levelId; }
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	public String getContent() { return this.content; }
	public void setContent(String content) { this.content = content; }
}