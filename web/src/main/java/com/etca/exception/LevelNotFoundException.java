package com.etca.exception;

import com.etca.model.Level;

public class LevelNotFoundException extends Exception{

	public LevelNotFoundException(String level){
		super("Could not find level: " + level);
	}

	public LevelNotFoundException(Level level){
		super("Could not find level: " + level.getTitle());
	}
}