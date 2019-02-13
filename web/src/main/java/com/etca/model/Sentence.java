package com.etca.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Sentence{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column
	private String text;

	@Column
	private String translation;

	@ManyToOne
	@JoinColumn
	private Lesson lesson;


	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public String getText() { return this.text; }
	public void setText(String text) { this.text = text; }
	public String getTranslation() { return this.translation; }
	public void setTranslation(String translation) { this.translation = translation; }
	public Lesson getLesson() { return this.lesson; }
	public void setLesson(Lesson lesson) { this.lesson = lesson; }
}