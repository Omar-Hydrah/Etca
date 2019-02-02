package com.etca.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.etca.model.Level;
import com.etca.model.Language;
import com.etca.repo.LevelRepository;

@Service
public class LevelService {
    
    @Autowired
    private LevelRepository repo;

    public List<Level> findAll(){
    	return repo.findAll();
    }

}
