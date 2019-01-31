package com.etca.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.etca.model.Word;
import com.etca.repo.WordRepository;

@Service
public class WordService{
	@Autowired
	private WordRepository repo;

	public Word createWord(Word word){
		return repo.save(word);
	}

}