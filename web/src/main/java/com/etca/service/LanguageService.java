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


    public List<Language> getAll(){
    	return repo.findAll();
    }
}
