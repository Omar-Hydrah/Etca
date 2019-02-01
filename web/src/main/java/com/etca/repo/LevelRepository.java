package com.etca.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.etca.model.Level;
import com.etca.model.Language;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long>{

	Level findByTitle(String title);

	List<Level> findByTitleLike(String title);
	List<Level> findAll();
	List<Level> findByLanguage(Language language);

	Level save(Level level);

}