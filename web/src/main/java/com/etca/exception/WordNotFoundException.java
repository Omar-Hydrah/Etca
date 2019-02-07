package com.etca.exception;

import com.etca.model.Word;

public class WordNotFoundException extends Exception{

	public WordNotFoundException(String word){
		super("Could not find word: " + word);
	}

	public WordNotFoundException(Word word){
		super("Could not find word: " + word.getWord());
	}
}