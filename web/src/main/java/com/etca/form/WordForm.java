package com.etca.form;

import javax.validation.constraints.NotEmpty;


public class WordForm{
	@NotEmpty
	private String word;

	@NotEmpty
	private String language;

	@NotEmpty
	private String level;

	public String getWord() { return this.word; }
	public void setWord(String word) { this.word = word; }
	public String getLanguage() { return this.language; }
	public void setLanguage(String language) { this.language = language; }
	public String getLevel() { return this.level; }
	public void setLevel(String level) { this.level = level; }

	@Override
	public String toString(){
		return 
			"{" +
			"word: " + word + ", " +
			"language: " + language + ", "+
			"level: " + level + ", " +
			"}";
	}
}