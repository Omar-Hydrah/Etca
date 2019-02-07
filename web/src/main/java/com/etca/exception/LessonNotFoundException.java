package com.etca.exception;

import com.etca.model.Lesson;

public class LessonNotFoundException extends Exception{

	public LessonNotFoundException(int lessonId){
		super("Could not find lesson id: " + lessonId);
	}

	public LessonNotFoundException(String lessonTitle){
		super("Could not find lesson title: " + lessonTitle);
	}

	public LessonNotFoundException(Lesson lesson){
		super("Could not find lesson: " + lesson.toString());
	}
}