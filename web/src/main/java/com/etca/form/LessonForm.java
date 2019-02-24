package com.etca.form;

import java.util.List;
import java.util.ArrayList;

import javax.validation.constraints.NotEmpty;

import com.etca.model.Language;
import com.etca.model.Sentence;
import com.etca.model.Lesson;
import com.etca.model.Level;

public class LessonForm{

	@NotEmpty
	private String title;

	@NotEmpty
	private String language;

	@NotEmpty
	private String level;

	@NotEmpty
	private List<Sentence> sentences;

	public LessonForm(){
		this.sentences = new ArrayList<>();
	}

	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	public String getLanguage() { return this.language; }
	public void setLanguage(String language) { this.language = language; }
	public List<Sentence> getSentences() { return this.sentences; }
	public void setSentences(List<Sentence> sentences) { this.sentences = sentences; }
	public String getLevel() { return this.level; }
	public void setLevel(String level) { this.level = level; }

	public void addSentence(Sentence sentence){
		if(this.sentences == null){
			this.sentences = new ArrayList<>();
		}

		this.sentences.add(sentence);
	}

	@Override
	public String toString(){

		StringBuilder sentencesString = new StringBuilder();

		for(int i = 0; i < sentences.size(); i++){
			sentencesString.append(sentences.get(i).toString());
		}

		return "{" +
			"title: " + this.title + ", " +
			"language: " + this.language + ", " +
			"sentences : [" + sentencesString + "], " +
			"}";
	}
	
}