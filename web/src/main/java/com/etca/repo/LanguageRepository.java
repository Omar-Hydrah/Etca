package com.etca.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.etca.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
	
	List<Language> findAll();
	Language save(Language language);
}