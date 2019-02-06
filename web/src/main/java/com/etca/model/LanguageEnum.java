package com.etca.model;

public enum LanguageEnum{
	english("english") , 
	turkish("turkish") , 
	french("french") , 
	russian("russian"), 
	spanish("spanish") , 
	arabic("arabic"),
	indonesian("indonesian");

	private String language;

	LanguageEnum(String language){
		this.language = language;
	}

	public String getLanguage(){return this.language;}
}