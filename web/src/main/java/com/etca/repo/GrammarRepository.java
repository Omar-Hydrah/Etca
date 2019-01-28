package com.etca.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etca.model.Grammar;
import java.util.List;

@Repository
public interface GrammarRepository extends JpaRepository<Grammar, Long>{

	Grammar findByTitle(String title);
	
	List<Grammar> findByTitleLike(String title);
	List<Grammar> findAll();

	Grammar save(Grammar grammar);
}