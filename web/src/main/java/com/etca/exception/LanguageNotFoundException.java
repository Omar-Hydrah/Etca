package com.etca.exception;


public class LanguageNotFoundException extends Exception{
	public LanguageNotFoundException(String language){
		super("Could not find: " + language + " language");
	}
}