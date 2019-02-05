package com.etca.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.etca.repo.LanguageRepository;
import com.etca.model.Language;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository repo;


    public List<Language> findAll(){
    	return repo.findAll();
    }

    public String[] findAllArray(){
    	List<Language> languagesList = repo.findAll();
    	String[] languages = new String[languagesList.size()];

    	for(int i = 0; i < languagesList.size(); i++){
    		languages[i] = languagesList.get(i).getLanguage();
    	}

    	return languages;
    }
}
