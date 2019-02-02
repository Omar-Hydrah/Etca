package com.etca.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.etca.model.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long>{

	Level findByTitle(String title);

	List<Level> findByTitleLike(String title);
	List<Level> findAll();

	Level save(Level level);

}