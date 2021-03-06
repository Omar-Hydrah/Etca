package com.etca.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etca.model.Word;
import com.etca.repo.WordRepository;
import com.etca.form.WordForm;
import com.etca.service.LevelService;
import com.etca.service.LanguageService;

@Service
public class WordService{

	private static final Logger logger = 
		LoggerFactory.getLogger(WordService.class);

	@Autowired
	private WordRepository repo;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private LevelService levelService;

	public Word save(Word word){
		return repo.save(word);
	}

	public Word save(WordForm wordForm){

		String text     = wordForm.getWord();
		String language = wordForm.getLanguage();
		String level    = wordForm.getLevel();

		Word word = new Word(text, Long.valueOf(language), Long.valueOf(level));

		return repo.save(word);
	}

	public Word createWord(Word word){
		return repo.save(word);
	}

	public List<Word> findAll(){
		return repo.findAll();
	}

}