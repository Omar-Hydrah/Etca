package com.etca.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.etca.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long>{

	
	Word save(Word word);
}