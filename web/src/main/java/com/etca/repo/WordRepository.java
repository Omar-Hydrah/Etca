package com.etca.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.etca.model.Word;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long>{

	List<Word> findAll();
	Word save(Word word);
}