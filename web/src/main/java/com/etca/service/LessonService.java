package com.etca.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import com.etca.repo.LessonRepository;
import com.etca.model.Lesson;
import com.etca.model.Language;
import com.etca.model.Level;

@Service
public class LessonService{

	@Autowired
	private LessonRepository repo;


	public Lesson findByTitle(String title){
		return repo.findByTitle(title);
	}

	public Optional<Lesson> findById(Long id){
		return repo.findById(id);
	}

	public List<Lesson> findAll(){
		return repo.findAll();
	}

	public List<Lesson> findByLanguage(Language language){
		return repo.findByLanguage(language);
	}

	public List<Lesson> findByLanguageAndLevel(Language language, Level level){
		return repo.findByLanguageAndLevel(language, level);
	}

	public Lesson save(Lesson lesson){
		return repo.save(lesson);
	}

}